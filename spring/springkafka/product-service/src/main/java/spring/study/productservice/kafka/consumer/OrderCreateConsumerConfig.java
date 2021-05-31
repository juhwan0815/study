package spring.study.productservice.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
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
import spring.study.productservice.kafka.message.OrderCreateMessage;

import java.util.Map;

@EnableKafka
@Configuration
public class OrderCreateConsumerConfig {

    @Value("${kafka.server}")
    private String kafkaServer;

    @Value("${kafka.consumer.create.groupName}")
    private String groupName;

    @Bean(name = "orderCreateConsumerFactory")
    public ConsumerFactory<String,OrderCreateMessage> orderCreateConsumerFactory(){
        JsonDeserializer<OrderCreateMessage> deserializer = JsonDeserializer();

        return new DefaultKafkaConsumerFactory<>(
                consumerFactoryConfig(deserializer),
                new StringDeserializer(),
                deserializer);
    }

    @Bean(name = "kafkaOrderCreateListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String,OrderCreateMessage> kafkaOrderCreateListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, OrderCreateMessage> kafkaListenerContainerFactory
                = new ConcurrentKafkaListenerContainerFactory<>();

        kafkaListenerContainerFactory.setConsumerFactory(orderCreateConsumerFactory());

        return kafkaListenerContainerFactory;
    }

    @ConditionalOnMissingBean(name = "kafkaOrderCreateListenerContainerFactory")
    private Map<String,Object> consumerFactoryConfig(JsonDeserializer<OrderCreateMessage> deserializer){
        return KafkaConfig.consumerFactoryConfig(kafkaServer,groupName,deserializer);
    }

    private JsonDeserializer<OrderCreateMessage> JsonDeserializer() {
        JsonDeserializer<OrderCreateMessage> deserializer = new JsonDeserializer<>(OrderCreateMessage.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);
        return deserializer;
    }
}
