package spring.study.orderservice.kafka.consumer;

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
import spring.study.orderservice.kafka.config.KafkaConfig;
import spring.study.orderservice.kafka.message.OrderCreateResultMessage;

import java.util.Map;

@EnableKafka
@Configuration
public class OrderCreateResultConsumerConfig {

    @Value("${kafka.server}")
    private String kafkaServer;

    @Value("${kafka.consumer.create.result.groupName}")
    private String groupName;

    @Bean(name = "orderCreateResultConsumerFactory")
    public ConsumerFactory<String, OrderCreateResultMessage> orderCreateResultConsumerFactory(){
        JsonDeserializer<OrderCreateResultMessage> deserializer = JsonDeserializer();

        return new DefaultKafkaConsumerFactory<>(
                consumerFactoryConfig(deserializer),
                new StringDeserializer(),
                deserializer);
    }

    @Bean(name = "kafkaOrderCreateListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String,OrderCreateResultMessage> kafkaOrderCreateListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String , OrderCreateResultMessage> kafkaListenerContainerFactory
                = new ConcurrentKafkaListenerContainerFactory<>();

        kafkaListenerContainerFactory.setConsumerFactory(orderCreateResultConsumerFactory());
        return kafkaListenerContainerFactory;
    }

    @ConditionalOnMissingBean(name = "kafkaOrderCreateResultListenerContainerFactory")
    private Map<String,Object> consumerFactoryConfig(JsonDeserializer<OrderCreateResultMessage> deserializer){
        return KafkaConfig.consumerFactoryConfig(kafkaServer,groupName,deserializer);
    }

    private JsonDeserializer<OrderCreateResultMessage> JsonDeserializer() {
        JsonDeserializer<OrderCreateResultMessage> deserializer = new JsonDeserializer<>(OrderCreateResultMessage.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);
        return deserializer;
    }
}
