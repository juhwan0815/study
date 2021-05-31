package spring.study.orderservice.kafka.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import spring.study.orderservice.kafka.config.KafkaConfig;
import spring.study.orderservice.kafka.message.OrderCancelMessage;

import java.util.Map;

@EnableKafka
@Configuration
public class KafkaOrderCancelProducerConfig {

    @Value("${kafka.server}")
    private String kafkaServer;

    @Bean(name = "orderCancelProducerFactory")
    public ProducerFactory<String, OrderCancelMessage> producerFactory(){
        Map<String, Object> properties = KafkaConfig.producerFactoryConfig(kafkaServer);

        return new DefaultKafkaProducerFactory<>(properties);
    }

    @Bean(name = "orderCancelKafkaTemplate")
    public KafkaTemplate<String,OrderCancelMessage> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
