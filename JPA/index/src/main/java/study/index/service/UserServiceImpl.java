package study.index.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.index.domain.Todo;
import study.index.domain.User;
import study.index.dto.user.UserCreateRequest;
import study.index.dto.user.UserResponse;
import study.index.repository.UserQueryRepository;
import study.index.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserQueryRepository userQueryRepository;

    @PostConstruct
    public void init() {
        IntStream.range(1, 100000)
                .forEach(value -> {
                    User user = User.createUser("회원" + value, "email" + value, value);

//                    IntStream.range(1,5)
//                                    .forEach(value1 -> {
//                                        Todo todo = Todo.createTodo("할일" + value1);
//                                        todo.setUser(user);
//                                    });
                    userRepository.save(user);
                });
    }

    @Override
    @Transactional
    public UserResponse createUser(UserCreateRequest request) {
        User user = User.createUser(request.getName(), request.getEmail(), request.getAge());
        userRepository.save(user);
        return UserResponse.from(user);
    }

    @Override
    public UserResponse findById(Long userId) {
        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("없어용"));
        return UserResponse.from(findUser);
    }

    @Override
    public UserResponse findByEmail(String email) {
        User findUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("없어용"));
        return UserResponse.from(findUser);
    }

    @Override
    public List<UserResponse> findPage(String name, int page, int pageSize, Long userId) {
        List<User> users = userQueryRepository.findLegacy(name, page, pageSize);
//        List<User> users = userQueryRepository.findNoOffset(userId, name, pageSize);
        return users.stream().map(user -> UserResponse.from(user)).collect(Collectors.toList());
    }


}
