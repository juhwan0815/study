package study.index.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.index.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
