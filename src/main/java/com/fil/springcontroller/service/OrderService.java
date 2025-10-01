package com.fil.springcontroller.service;

import com.fil.springcontroller.producer.KafkOrderProducer;
import com.fil.springcontroller.producer.OrderEventProducer;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderEventProducer orderEventProducer;
    private KafkOrderProducer kafkOrderProducer;
    private MeterRegistry meterRegistry;

    public OrderService(OrderEventProducer orderEventProducer, KafkOrderProducer kafkOrderProducer, MeterRegistry meterRegistry) {
        this.orderEventProducer = orderEventProducer;
        this.kafkOrderProducer = kafkOrderProducer;
        this.meterRegistry = meterRegistry;
    }

    public void createOrder(String orderId, double amount) {

        orderEventProducer.publish(orderId, amount);
        kafkOrderProducer.publish(orderId, amount);
        meterRegistry.counter("orders.created").increment();
    }
}
