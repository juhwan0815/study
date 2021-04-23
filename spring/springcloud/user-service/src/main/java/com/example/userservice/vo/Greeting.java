package com.example.userservice.vo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Greeting {

    // application.yml 에 있는 설정을 가져온다.
    @Value("${greeting.message}")
    private String message;
}
