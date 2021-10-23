package spring.study.replication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import spring.study.replication.config.CustomDataSourceProperties;

@SpringBootApplication
public class ReplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReplicationApplication.class, args);
    }

}
