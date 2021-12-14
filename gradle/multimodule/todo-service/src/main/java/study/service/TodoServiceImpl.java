package study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.domain.Todo;
import study.dto.TodoCreateRequest;
import study.dto.TodoResponse;
import study.repository.TodoRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    @Override
    @Transactional
    public TodoResponse createTodo(TodoCreateRequest request) {
        Todo todo = Todo.createTodo(request.getContent());
        todoRepository.save(todo);
        return TodoResponse.from(todo);
    }
}
