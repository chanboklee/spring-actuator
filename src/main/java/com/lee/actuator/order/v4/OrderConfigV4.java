package com.lee.actuator.order.v4;

import com.lee.actuator.order.OrderService;
import com.lee.actuator.order.v3.OrderServiceV3;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfigV4 {

    @Bean
    OrderService orderService(){
        return new OrderServiceV4();
    }

    @Bean
    public TimedAspect timedAspect(MeterRegistry registry){
        return new TimedAspect(registry);
    }
}
