package com.redis.study.redis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    private String name;

    private String email;

    private String password;

}
