package study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.dto.UserCreateRequest;
import study.dto.UserResponse;
import study.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserResponse createUser(@RequestBody UserCreateRequest request){
        return userService.createUser(request);
    }

    @GetMapping("/users/{userId}")
    public UserResponse findUser(@PathVariable Long userId){
        return userService.findUser(userId);
    }

}
