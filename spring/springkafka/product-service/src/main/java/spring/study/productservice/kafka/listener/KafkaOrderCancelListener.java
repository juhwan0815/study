package spring.study.productservice.kafka.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import spring.study.productservice.kafka.message.OrderCancelMessage;
import spring.study.productservice.service.ProductService;

@Component
@RequiredArgsConstructor
public class KafkaOrderCancelListener {

    private final ProductService productService;

    @KafkaListener(topics = "${kafka.topic.cancel.name}",
            groupId = "${kafka.consumer.cancel.groupName}",
            containerFactory = "kafkaOrderCancelListenerContainerFactory")
    public void orderCancelListen(@Payload OrderCancelMessage orderCancelMessage,
                                  @Headers MessageHeaders messageHeaders){
        productService.plusStock(orderCancelMessage);
    }

}
