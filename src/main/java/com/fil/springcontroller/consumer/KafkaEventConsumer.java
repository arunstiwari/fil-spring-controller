package com.fil.springcontroller.consumer;

import com.fil.springcontroller.entity.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//@Component
public class KafkaEventConsumer {

//    @KafkaListener(topics = "order-created-event", groupId = "fil-group")
//    public void kafkaConsumerOfOrderEvent(OrderCreatedEvent orderCreatedEvent){
//        System.out.println("Received order event from Kafka: "+orderCreatedEvent);
//    }
}
