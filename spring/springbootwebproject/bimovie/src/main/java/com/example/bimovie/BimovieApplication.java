package com.example.bimovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BimovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(BimovieApplication.class, args);
    }

}
