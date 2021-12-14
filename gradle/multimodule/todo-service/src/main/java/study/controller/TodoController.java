package study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.dto.TodoCreateRequest;
import study.dto.TodoResponse;
import study.service.TodoService;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public TodoResponse createTodo(@RequestBody TodoCreateRequest request){
        return todoService.createTodo(request);
    }
}
