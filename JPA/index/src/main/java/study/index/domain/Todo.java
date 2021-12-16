package study.index.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.index.repository.TodoRepository;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    private String content;

    private Boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public static Todo createTodo(String content){
        Todo todo = new Todo();
        todo.content = content;
        todo.completed = false;
        return todo;
    }

    public void setUser(User user) {
        this.user = user;
        user.getTodos().add(this);
    }
}
