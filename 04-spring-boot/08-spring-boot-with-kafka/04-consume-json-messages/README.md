# Lesson 4: Consuming JSON Messages with Spring Kafka

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../03-publish-json-messages/README.md) | [Next Lesson →](../05-publish-string-messages/README.md)

> 📂 **Runnable Example Project:**  
> 👉 **Complete Project:** [Consume JSON Events via @KafkaListener](../../examples/04-kafka-messaging)  
> 📄 **Source Code Files:** [`OrderEventConsumer.java`](../../examples/04-kafka-messaging/src/main/java/com/example/kafka/consumer/OrderEventConsumer.java) | [`OrderCreatedEvent.java`](../../examples/04-kafka-messaging/src/main/java/com/example/kafka/event/OrderCreatedEvent.java) | [`application.yml`](../../examples/04-kafka-messaging/src/main/resources/application.yml)


---

## Table of Contents
1. [Spring Kafka JSON Deserialization Architecture](#deserialization-architecture)
2. [Configuring JsonDeserializer and Trusted Packages](#configuring-trusted-packages)
3. [Type-Safe @KafkaListener Consumer Implementation](#typesafe-listener)
4. [Handling Type Header Mismatches](#type-header-mismatches)

---

## Configuring JsonDeserializer with Trusted Packages

In `application.yml`:
```yaml
spring:
  kafka:
    consumer:
      bootstrap-servers: localhost:9092
      group-id: inventory-service-group
      auto-offset-reset: earliest
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.springframework.kafka.support.serializer.JsonDeserializer
      properties:
        spring.json.trusted.packages: "com.example.event,com.example.dto"
        spring.json.value.default.type: "com.example.event.OrderCreatedEvent"
```

---

## Type-Safe @KafkaListener Consumer Implementation

```java
package com.example.consumer;

import com.example.event.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {

    private static final Logger log = LoggerFactory.getLogger(OrderEventConsumer.class);

    @KafkaListener(topics = "order-created-events", groupId = "inventory-service-group")
    public void handleOrderCreated(OrderCreatedEvent event) {
        log.info("Successfully received order event for orderId: {}", event.orderId());
        log.info("Customer Email: {}, Amount: ${}", event.customerEmail(), event.totalAmount());
    }
}
```

---

## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Publishing JSON Messages with Kafka](../03-publish-json-messages/README.md) | [📚 Module Index](../README.md) | [Publishing String Messages with Kafka →](../05-publish-string-messages/README.md) |
