package study.event.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publish(String message) {
        System.out.println("Publishing custom event");
        CustomEvent customEvent = new CustomEvent(this, message);
        applicationEventPublisher.publishEvent(customEvent);
    }


}
