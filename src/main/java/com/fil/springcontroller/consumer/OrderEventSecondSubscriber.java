package com.fil.springcontroller.consumer;

import com.fil.springcontroller.entity.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class OrderEventSecondSubscriber {
    @Async
    @EventListener
    public  void handleOrderEvent(OrderCreatedEvent orderCreatedEvent) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Second Subscriber is Sending Email to Customer for orderCreatedEvent = " + orderCreatedEvent);
    }
}
