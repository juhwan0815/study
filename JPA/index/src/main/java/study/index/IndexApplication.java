package study.index;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import study.index.aop.TransactionTimeAspect;

@SpringBootApplication
public class IndexApplication {

    public static void main(String[] args) {
        SpringApplication.run(IndexApplication.class, args);
    }

    @Bean
    public TransactionTimeAspect transactionTimeAspect(){
        return new TransactionTimeAspect();
    }

}
