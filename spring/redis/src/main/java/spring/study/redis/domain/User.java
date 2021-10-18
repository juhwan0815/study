package spring.study.redis.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;

    private String email;

    private String password;

    public static User createUser(String name,String email,String password){
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }

    public void updateUser(String name, String password){
        this.name = name;
        this.password = password;
    }

}
