package com.fil.springcontroller.producer;

import com.fil.springcontroller.entity.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkOrderProducer {
    private final String TOPIC ="order-created-event";
    @Autowired
    private  KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

//    public KafkOrderProducer(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }

    public void publish(String orderId, double amount) {
        System.out.println("Order Created Event Published for orderId: " + orderId + " with amount: " + amount);
        kafkaTemplate.send(TOPIC, new OrderCreatedEvent(orderId, amount));
    }
}
