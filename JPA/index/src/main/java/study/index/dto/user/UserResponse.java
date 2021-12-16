package study.index.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.index.domain.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;

    private String name;

    private String email;

    private Integer age;

    public static UserResponse from(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.id = user.getId();
        userResponse.name = user.getName();
        userResponse.email = user.getEmail();
        userResponse.age = user.getAge();
        return userResponse;
    }
}
