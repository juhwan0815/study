package study.event.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.event.event.CustomEventPublisher;
import study.event.event.GenericEventPublisher;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final CustomEventPublisher customEventPublisher;
    private final GenericEventPublisher<String> genericEventPublisher;

    @GetMapping("/event")
    public String event(@RequestParam String message) {
        customEventPublisher.publish(message);
        return "finished";
    }

    @GetMapping("/event/generic")
    public String event(@RequestParam String message, @RequestParam boolean success) {
        genericEventPublisher.publish(message, success);
        return "finished";
    }
}
