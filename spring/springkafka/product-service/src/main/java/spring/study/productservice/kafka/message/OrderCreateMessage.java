package spring.study.productservice.kafka.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateMessage {

    private Long orderId;

    private Integer count;

    private Long productId;

}
