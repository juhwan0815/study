package study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.domain.User;
import study.dto.UserCreateRequest;
import study.dto.UserResponse;
import study.exeption.DuplicateException;
import study.repository.UserQueryRepository;
import study.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserQueryRepository userQueryRepository;

    @Override
    @Transactional
    public UserResponse createUser(UserCreateRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new DuplicateException("예외 발생");
        }
        User user = User.createUser(request.getName(), request.getEmail(), request.getAge());
        userRepository.save(user);
        return UserResponse.from(user);
    }

    @Override
    public UserResponse findUser(Long userId) {
        User user = userQueryRepository.findById(userId);
        return UserResponse.from(user);

    }
}
