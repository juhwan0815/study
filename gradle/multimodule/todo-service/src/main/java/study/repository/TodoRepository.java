package study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
