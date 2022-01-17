package study.event.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;
import study.event.event.CustomEvent;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class User extends AbstractAggregateRoot<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private int age;

    public static User createUser(int age){
        User user = new User();
        user.age = age;
        return user;
    }

    public void addAge() {
        this.age++;
        registerEvent(new CustomEvent(this, "user age is " + this.age));
    }
}
