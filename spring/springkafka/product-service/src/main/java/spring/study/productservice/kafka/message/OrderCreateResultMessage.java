package spring.study.productservice.kafka.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateResultMessage {

    private Long orderId;

    private Long productId;

    private ProductStockChangeResult result;

    public static OrderCreateResultMessage createResultMessage(OrderCreateMessage orderCreateMessage,ProductStockChangeResult result){
        OrderCreateResultMessage orderCreateResultMessage = new OrderCreateResultMessage();
        orderCreateResultMessage.orderId = orderCreateMessage.getOrderId();
        orderCreateResultMessage.productId = orderCreateMessage.getProductId();
        orderCreateResultMessage.result = result;
        return orderCreateResultMessage;
    }

}
