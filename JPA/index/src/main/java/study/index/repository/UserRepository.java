package study.index.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.index.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

}
