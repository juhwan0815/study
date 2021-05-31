package spring.study.productservice.kafka.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import spring.study.productservice.kafka.message.OrderCreateMessage;
import spring.study.productservice.service.ProductService;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaOrderCreateListener {

    private final ProductService productService;

    @KafkaListener(topics = "${kafka.topic.create.name}",
            groupId = "${kafka.consumer.create.groupName}",
            containerFactory = "kafkaOrderCreateListenerContainerFactory")
    public void orderCreateListen(@Payload OrderCreateMessage orderCreateMessage,
                                  @Headers MessageHeaders messageHeaders){
        productService.changeStock(orderCreateMessage);
    }
}
