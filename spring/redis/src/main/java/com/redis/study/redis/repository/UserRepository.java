package com.redis.study.redis.repository;

import com.redis.study.redis.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

}
