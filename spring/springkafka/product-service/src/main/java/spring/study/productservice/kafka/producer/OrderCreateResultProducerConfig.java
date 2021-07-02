package spring.study.productservice.kafka.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import spring.study.productservice.kafka.config.KafkaConfig;
import spring.study.productservice.kafka.message.OrderCreateResultMessage;

import java.util.Map;

@EnableKafka
@Configuration
public class OrderCreateResultProducerConfig {

    @Value("${kafka.server}")
    private String kafkaServer;

    @Bean(name = "orderCreateResultProducerFactory")
    public ProducerFactory<String, OrderCreateResultMessage> producerFactory(){
        Map<String, Object> properties = KafkaConfig.producerFactoryConfig(kafkaServer);
        return new DefaultKafkaProducerFactory<>(properties);
    }

    @Bean(name = "orderCreateResultKafkaTemplate")
    public KafkaTemplate<String,OrderCreateResultMessage> kafkaTemplate(){
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
