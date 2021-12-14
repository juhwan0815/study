package study.service;

import study.dto.TodoCreateRequest;
import study.dto.TodoResponse;

public interface TodoService {

    TodoResponse createTodo(TodoCreateRequest request);
}
