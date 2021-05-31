package spring.study.productservice.kafka.consumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import spring.study.productservice.kafka.config.KafkaConfig;
import spring.study.productservice.kafka.message.OrderCancelMessage;

import java.util.Map;

@EnableKafka
@Configuration
public class OrderCancelConsumerConfig {

    @Value("${kafka.server}")
    private String kafkaServer;

    @Value("${kafka.consumer.cancel.groupName}")
    private String groupName;

    @Bean(name = "orderCancelConsumerFactory")
    public ConsumerFactory<String, OrderCancelMessage> orderCancelConsumerFactory(){
        JsonDeserializer<OrderCancelMessage> deserializer = jsonDeserializer();

        return new DefaultKafkaConsumerFactory<>(
                consumerFactoryConfig(deserializer),
                new StringDeserializer(),
                deserializer);
    }

    @Bean(name = "kafkaOrderCancelListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String,OrderCancelMessage> kafkaOrderCancelListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String , OrderCancelMessage> kafkaListenerContainerFactory
                = new ConcurrentKafkaListenerContainerFactory<>();

        kafkaListenerContainerFactory.setConsumerFactory(orderCancelConsumerFactory());

        return kafkaListenerContainerFactory;
    }



    @ConditionalOnMissingBean(name = "kafkaOrderCancelListenerContainerFactory")
    private Map<String,Object> consumerFactoryConfig(JsonDeserializer<OrderCancelMessage> deserializer){
        return KafkaConfig.consumerFactoryConfig(kafkaServer,groupName,deserializer);
    }

    private JsonDeserializer<OrderCancelMessage> jsonDeserializer(){
        JsonDeserializer<OrderCancelMessage> deserializer = new JsonDeserializer<>(OrderCancelMessage.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);
        return deserializer;
    }
}
