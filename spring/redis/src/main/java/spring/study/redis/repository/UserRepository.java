package spring.study.redis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.study.redis.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
