package com.fil.springcontroller.producer;

import com.fil.springcontroller.entity.OrderCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class OrderEventProducer {
    private ApplicationEventPublisher publisher;

    public OrderEventProducer(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish(String orderId, double amount) {
        System.out.println("Order Created Event Published for orderId: " + orderId + " with amount: " + amount);
        publisher.publishEvent(new OrderCreatedEvent(orderId, amount));
    }

}
