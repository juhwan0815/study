package spring.study.orderservice.kafka.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.study.orderservice.domain.Order;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCancelMessage {

    private Long productId;

    private Integer count;

    public static OrderCancelMessage from(Order order){
        OrderCancelMessage orderCancelMessage = new OrderCancelMessage();
        orderCancelMessage.productId = order.getProductId();
        orderCancelMessage.count = order.getCount();
        return orderCancelMessage;
    }
}
