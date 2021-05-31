package spring.study.orderservice.kafka.message;

import lombok.Data;
import spring.study.orderservice.domain.Order;

@Data
public class OrderCreateMessage {

    private Long orderId;

    private Long productId;

    private Integer count;

    public static OrderCreateMessage from(Order order){
        OrderCreateMessage orderCreateMessage = new OrderCreateMessage();
        orderCreateMessage.orderId = order.getId();
        orderCreateMessage.count = order.getCount();
        orderCreateMessage.productId = order.getProductId();
        return orderCreateMessage;
    }
}
