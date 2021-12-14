package study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.domain.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;

    private String email;

    private String name;

    private Integer age;

    public static UserResponse from(User user){
        return new UserResponse(user.getId(), user.getEmail(), user.getName(), user.getAge());
    }
}
