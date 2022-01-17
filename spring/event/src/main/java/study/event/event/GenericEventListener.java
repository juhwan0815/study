package study.event.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class GenericEventListener {

    @EventListener(condition = "#event.success")
    public void handlerEvent(GenericEvent event) {
        System.out.println("Received spring generic event by annotation listener - " + event.getResult());
    }
}
