package com.fil.springcontroller.service;

import com.fil.springcontroller.producer.OrderEventProducer;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderEventProducer orderEventProducer;

    public OrderService(OrderEventProducer orderEventProducer) {
        this.orderEventProducer = orderEventProducer;
    }

    public void createOrder(String orderId, double amount) {

        orderEventProducer.publish(orderId, amount);
    }
}
