package study.index.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.index.dto.user.UserCreateRequest;
import study.index.dto.user.UserResponse;
import study.index.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserResponse createUser(@RequestBody UserCreateRequest request){
        return userService.createUser(request);
    }

    @GetMapping("/users/{userId}")
    public UserResponse findById(@PathVariable Long userId){
        return userService.findById(userId);
    }

    @GetMapping("/users")
    public UserResponse findByEmail(@RequestParam String email){
        return userService.findByEmail(email);
    }
}
