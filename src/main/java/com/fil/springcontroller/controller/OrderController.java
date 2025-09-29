package com.fil.springcontroller.controller;

import com.fil.springcontroller.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{orderId}/{amount}")
    public void createOrder(@PathVariable String orderId, @PathVariable double amount) {
        orderService.createOrder(orderId, amount);
    }
}
