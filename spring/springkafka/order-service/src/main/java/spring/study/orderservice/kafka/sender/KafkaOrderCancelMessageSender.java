package spring.study.orderservice.kafka.sender;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import spring.study.orderservice.kafka.message.OrderCancelMessage;
import spring.study.orderservice.kafka.message.OrderCreateMessage;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaOrderCancelMessageSender {

    @Qualifier("orderCancelKafkaTemplate")
    private final KafkaTemplate<String, OrderCancelMessage> kafkaTemplate;

    @Value("${kafka.topic.cancel.name}")
    private String topic;

    public void send(OrderCancelMessage orderCancelMessage){
        Message<OrderCancelMessage> message = MessageBuilder
                .withPayload(orderCancelMessage)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        ListenableFuture<SendResult<String, OrderCancelMessage>> future = kafkaTemplate.send(message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, OrderCancelMessage>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.info("Unable to send message=[] due to : {}",ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, OrderCancelMessage> result) {
                log.info("Sent message={} to topic{} with offset={}",
                        result.getProducerRecord().value().toString(),
                        result.getRecordMetadata().topic(),
                        result.getRecordMetadata().hasOffset());
            }
        });
    }
}
