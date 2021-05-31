package spring.study.orderservice.kafka.message;

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
}
