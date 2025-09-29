package com.fil.springcontroller.consumer;

import com.fil.springcontroller.entity.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventSubscriber {

    @EventListener
    public  void handleOrderEvent(OrderCreatedEvent orderCreatedEvent){
        System.out.println("Sending Fullfillment service for orderCreatedEvent = " + orderCreatedEvent);
    }

}
