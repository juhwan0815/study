package hello.order.v3;

import hello.order.OrderService;
import hello.order.v2.OrderServiceV2;
import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfigV3 {

    @Bean
    public OrderService orderService(MeterRegistry registry) {
        return new OrderServiceV3(registry);
    }


}
