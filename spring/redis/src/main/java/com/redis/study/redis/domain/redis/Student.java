package com.redis.study.redis.domain.redis;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@Getter
@Builder
@RedisHash("student") // redis를 jpaRepository 사용하듯이 쓸 수 있게 해주는 어노테이션
public class Student {

    @Id
    private Long studentId;
    private String name;

    public void update(String name){
        this.name = name;
    }
}
