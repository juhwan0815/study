package study.service;

import study.dto.UserCreateRequest;
import study.dto.UserResponse;

public interface UserService {

    UserResponse createUser(UserCreateRequest request);

    UserResponse findUser(Long userId);
}
