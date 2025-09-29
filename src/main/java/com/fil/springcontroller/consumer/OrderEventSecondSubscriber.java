package com.fil.springcontroller.consumer;

import com.fil.springcontroller.entity.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventSecondSubscriber {
    @EventListener
    public  void handleOrderEvent(OrderCreatedEvent orderCreatedEvent){
        System.out.println("Second Subscriber is Sending Email to Customer for orderCreatedEvent = " + orderCreatedEvent);
    }
}
