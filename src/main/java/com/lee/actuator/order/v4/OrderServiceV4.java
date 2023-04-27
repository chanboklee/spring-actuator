package com.lee.actuator.order.v4;

import com.lee.actuator.order.OrderService;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Timed("my.order")
@Slf4j
@RequiredArgsConstructor
public class OrderServiceV4 implements OrderService {
    private AtomicInteger stock = new AtomicInteger(100);

    @Override
    public void order() {
        log.info("order");
        stock.decrementAndGet();
        sleep(500);
    }

    private static void sleep(int l){
        try {
            Thread.sleep(l + new Random().nextInt(200));
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cancel() {
        log.info("cancel");
        stock.incrementAndGet();
        sleep(200);
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
