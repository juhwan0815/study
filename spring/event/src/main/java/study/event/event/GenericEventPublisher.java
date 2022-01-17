package study.event.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenericEventPublisher<T> {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publish(T message, boolean success) {
        System.out.println("Publishing generic event.");
        GenericEvent<Object> genericEvent = new GenericEvent<>(message, success);
        applicationEventPublisher.publishEvent(genericEvent);
    }
}
