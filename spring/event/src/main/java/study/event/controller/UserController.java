package study.event.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import study.event.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<Map<String, Long>> create() {
        Map<String, Long> response = new HashMap<>();
        Long userId = userService.create();
        response.put("userId", userId);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/api/users/{userId}")
    public ResponseEntity<Void> update(@PathVariable Long userId){
        userService.addAge(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
