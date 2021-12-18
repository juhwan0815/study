package study.index.service;

import study.index.dto.user.UserCreateRequest;
import study.index.dto.user.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserCreateRequest request);

    UserResponse findById(Long userId);

    UserResponse findByEmail(String email);

    List<UserResponse> findPage(String name, int page, int pageSize, Long userId);

}
