package com.lee.actuator.order.v1;

import com.lee.actuator.order.OrderService;
import com.lee.actuator.order.v0.OrderServiceV0;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfigV1 {

    @Bean
    OrderService orderService(MeterRegistry registry){
        return new OrderServiceV1(registry);
    }
}
