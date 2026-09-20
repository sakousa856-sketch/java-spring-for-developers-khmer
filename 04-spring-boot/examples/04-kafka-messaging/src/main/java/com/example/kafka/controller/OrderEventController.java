package com.example.kafka.controller;

import com.example.kafka.event.OrderCreatedEvent;
import com.example.kafka.producer.OrderEventProducer;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderEventController {

    private final OrderEventProducer producer;

    public OrderEventController(OrderEventProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/create")
    public OrderCreatedEvent createOrder(@RequestParam String email, @RequestParam BigDecimal amount) {
        OrderCreatedEvent event = new OrderCreatedEvent(
                UUID.randomUUID().toString().substring(0, 8),
                email,
                amount,
                Instant.now()
        );
        producer.publishOrder(event);
        return event;
    }
}
