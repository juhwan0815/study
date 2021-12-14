package study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.domain.Todo;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoResponse {

    private Long id;

    private Boolean completed;

    private String content;

    public static TodoResponse from(Todo todo){
        return new TodoResponse(todo.getId(), todo.getCompleted(), todo.getContent());
    }
}
