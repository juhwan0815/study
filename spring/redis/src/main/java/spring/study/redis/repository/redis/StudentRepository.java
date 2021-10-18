package spring.study.redis.repository.redis;

import org.springframework.data.repository.CrudRepository;
import spring.study.redis.domain.redis.Student;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
