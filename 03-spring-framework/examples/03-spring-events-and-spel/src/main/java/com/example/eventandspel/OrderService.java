package com.example.eventandspel;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ApplicationEventPublisher publisher;

    public OrderService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void placeOrder(String orderId, String customer, double amount) {
        System.out.printf("[ORDER SERVICE] Order #%s recorded for %s ($%.2f)%n", orderId, customer, amount);
        System.out.println("[ORDER SERVICE] Publishing OrderPlacedEvent onto Spring Event Bus...");
        publisher.publishEvent(new OrderPlacedEvent(orderId, customer, amount));
    }
}
