package study.event.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import study.event.domain.User;
import study.event.domain.UserRepository;
import study.event.event.CustomEventPublisher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @MockBean
    private CustomEventPublisher customEventPublisher;

    @Test
    void serviceEventTest() {
        // given
        User user = User.createUser(10);
        userRepository.save(user);

        // when
        userService.addAge(user.getId());

        // then
        then(customEventPublisher).should(times(1)).publish(any());
    }

}