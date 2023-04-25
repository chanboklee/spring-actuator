package com.lee.actuator;

import com.lee.actuator.order.v0.OrderServiceV0;
import com.lee.actuator.order.v1.OrderServiceV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

// @Import(OrderServiceV0.class)
@Import({OrderServiceV1.class})
@SpringBootApplication(scanBasePackages = "com.lee.actuator.controller")
public class ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
    }

    @Bean
    public InMemoryHttpExchangeRepository httpExchangeRepository(){
        return new InMemoryHttpExchangeRepository();
    }
}
