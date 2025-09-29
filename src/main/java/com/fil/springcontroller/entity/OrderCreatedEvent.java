package com.fil.springcontroller.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderCreatedEvent {
    private String orderId;
    private double amount;

    public OrderCreatedEvent(@JsonProperty("orderId") String orderId,  @JsonProperty("amount") double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return new StringBuffer()
                .append("orderId = "+orderId)
                .append(", amount="+amount)
                .toString();
    }
}
