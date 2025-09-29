package com.fil.springcontroller.service;

import com.fil.springcontroller.producer.KafkOrderProducer;
import com.fil.springcontroller.producer.OrderEventProducer;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderEventProducer orderEventProducer;
    private KafkOrderProducer kafkOrderProducer;

    public OrderService(OrderEventProducer orderEventProducer, KafkOrderProducer kafkOrderProducer) {
        this.orderEventProducer = orderEventProducer;
        this.kafkOrderProducer = kafkOrderProducer;
    }

    public void createOrder(String orderId, double amount) {

        orderEventProducer.publish(orderId, amount);
        kafkOrderProducer.publish(orderId, amount);
    }
}
