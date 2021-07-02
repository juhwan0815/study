package spring.study.orderservice.kafka.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import spring.study.orderservice.kafka.config.KafkaConfig;
import spring.study.orderservice.kafka.message.OrderCreateMessage;

import java.util.Map;

@EnableKafka
@Configuration
public class KafkaOrderCreateProducerConfig {

    @Value("${kafka.server}")
    private String kafkaServer;

    @Bean(name = "orderCreateProducerFactory")
    public ProducerFactory<String, OrderCreateMessage> producerFactory() {
        Map<String, Object> properties = KafkaConfig.producerFactoryConfig(kafkaServer);

        return new DefaultKafkaProducerFactory<>(properties);
    }

    @Bean(name = "orderCreateKafkaTemplate")
    public KafkaTemplate<String, OrderCreateMessage> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("${kafka.topic.create.name}")
                .partitions(10)
                .replicas(3)
                .compact()
                .build();
    }

}
