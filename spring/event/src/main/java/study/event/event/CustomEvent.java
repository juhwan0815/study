package study.event.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CustomEvent extends ApplicationEvent {

    private String message;

    public CustomEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

}
