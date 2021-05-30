package spring.study.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.study.test.repository.HelloWorldRepository;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final HelloWorldRepository helloWorldRepository;

    @GetMapping("/api/helloWorld")
    public String helloWorld(){
        return "helloWorld";
    }




}
