package study.event.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.event.event.CustomEventPublisher;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final CustomEventPublisher customEventPublisher;

    @GetMapping("/event")
    public String event(@RequestParam String message) {
        customEventPublisher.publish(message);
        return "finished";
    }
}
