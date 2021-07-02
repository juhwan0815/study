package spring.study.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.study.orderservice.domain.Order;
import spring.study.orderservice.kafka.message.OrderCancelMessage;
import spring.study.orderservice.kafka.message.OrderCreateMessage;
import spring.study.orderservice.kafka.message.OrderCreateResultMessage;
import spring.study.orderservice.kafka.message.ProductStockChangeResult;
import spring.study.orderservice.kafka.sender.KafkaOrderCancelMessageSender;
import spring.study.orderservice.kafka.sender.KafkaOrderCreateMessageSender;
import spring.study.orderservice.model.OrderResponse;
import spring.study.orderservice.model.OrderSaveRequest;
import spring.study.orderservice.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final KafkaOrderCreateMessageSender kafkaOrderCreateMessageSender;
    private final KafkaOrderCancelMessageSender kafkaOrderCancelMessageSender;

    @Transactional
    public OrderResponse saveOrder(Long productId, OrderSaveRequest request) {

        Order order = Order.createOrder(request.getCount(), request.getPrice(), productId);

        Order savedOrder = orderRepository.save(order);

        // 카프카 메세지 전송
        kafkaOrderCreateMessageSender.send(OrderCreateMessage.from(savedOrder));

        return OrderResponse.from(savedOrder);
    }

    public List<OrderResponse> findOrders(){
        List<Order> findOrders = orderRepository.findAll();

        return findOrders.stream()
                .map(order -> OrderResponse.from(order))
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderResponse cancelOrder(Long orderId){
        Order findOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException());

        findOrder.cancel();

        kafkaOrderCancelMessageSender.send(OrderCancelMessage.from(findOrder));

        return OrderResponse.from(findOrder);
    }

    @Transactional
    public void successOrder(OrderCreateResultMessage orderCreateResultMessage) {

        Order findOrder = orderRepository.findById(orderCreateResultMessage.getOrderId())
                .orElseThrow(() -> new IllegalArgumentException());

        if (orderCreateResultMessage.getResult() == ProductStockChangeResult.SUCCESS) {
            findOrder.SuccessOrder();
        } else {
            findOrder.cancel();
        }
    }
}
