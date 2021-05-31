package spring.study.orderservice.kafka.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import spring.study.orderservice.kafka.message.OrderCreateResultMessage;
import spring.study.orderservice.service.OrderService;

@Component
@RequiredArgsConstructor
public class KafkaOrderCreateResultListener {

    private final OrderService orderService;


    @KafkaListener(topics = "${kafka.topic.create.result.name}",
            groupId = "${kafka.consumer.create.result.groupName}",
            containerFactory = "kafkaOrderCreateListenerContainerFactory")
    public void OrderCreateResultListen(@Payload OrderCreateResultMessage orderCreateResultMessage,
                                        @Headers MessageHeaders messageHeaders) {
        orderService.successOrder(orderCreateResultMessage);
    }


}
