package com.redis.study.redis.repository.redis;

import com.redis.study.redis.domain.redis.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
