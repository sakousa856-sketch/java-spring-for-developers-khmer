package com.example.kafka.consumer;

import com.example.kafka.event.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {
    private static final Logger log = LoggerFactory.getLogger(OrderEventConsumer.class);

    @KafkaListener(topics = "orders-topic", groupId = "order-event-group")
    public void consumeOrder(OrderCreatedEvent event) {
        log.info(">> Received Order Event from Kafka Consumer: {}", event);
    }
}
