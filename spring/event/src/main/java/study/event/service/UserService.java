package study.event.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.event.domain.User;
import study.event.domain.UserRepository;
import study.event.event.CustomEventPublisher;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final CustomEventPublisher customEventPublisher;

    @Transactional
    public void addAge(Long userId) {
        userRepository.findById(userId)
                .ifPresent(user -> {
                    user.addAge();
                    userRepository.save(user);
//                    customEventPublisher.publish("user age is " + user.getAge());
                });
    }

    @Transactional
    public Long create() {
        User user = User.createUser(10);
        userRepository.save(user);
        return user.getId();
    }
}
