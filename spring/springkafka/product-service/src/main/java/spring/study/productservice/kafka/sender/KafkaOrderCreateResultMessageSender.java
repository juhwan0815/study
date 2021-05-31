package spring.study.productservice.kafka.sender;

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
import spring.study.productservice.kafka.message.OrderCreateResultMessage;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaOrderCreateResultMessageSender {

    @Qualifier("orderCreateResultKafkaTemplate")
    private final KafkaTemplate<String, OrderCreateResultMessage> kafkaTemplate;

    @Value("${kafka.topic.create.result.name}")
    private String topic;

    public void send(OrderCreateResultMessage orderCreateResultMessage){
        Message<OrderCreateResultMessage> message = MessageBuilder
                .withPayload(orderCreateResultMessage)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        ListenableFuture<SendResult<String, OrderCreateResultMessage>> future = kafkaTemplate.send(message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, OrderCreateResultMessage>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.info("Unable to send message=[] due to : {}",ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, OrderCreateResultMessage> result) {
                log.info("Sent message={} to topic{} with offset={}",
                        result.getProducerRecord().value().toString(),
                        result.getRecordMetadata().topic(),
                        result.getRecordMetadata().hasOffset());
            }
        });
    }
}
