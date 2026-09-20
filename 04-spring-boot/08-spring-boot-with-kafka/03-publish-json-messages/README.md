# Lesson 3: Publishing JSON Messages with Kafka

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../02-kafka-consumer/README.md) | [Next Lesson →](../04-consume-json-messages/README.md)

> 📂 **Runnable Example Project:**  
> 👉 **Complete Project:** [Publish JSON Events via KafkaTemplate](../../examples/04-kafka-messaging)  
> 📄 **Source Code Files:** [`OrderEventProducer.java`](../../examples/04-kafka-messaging/src/main/java/com/example/kafka/producer/OrderEventProducer.java) | [`OrderCreatedEvent.java`](../../examples/04-kafka-messaging/src/main/java/com/example/kafka/event/OrderCreatedEvent.java) | [`application.yml`](../../examples/04-kafka-messaging/src/main/resources/application.yml)


---

## Table of Contents
1. [Why Structured JSON in Event-Driven Architectures?](#why-json)
2. [Jackson JsonSerializer Configuration](#jackson-jsonserializer)
3. [Creating Strongly-Typed Domain Event Records](#event-records)
4. [Building the Kafka Producer Service](#producer-service)
5. [Message Key Routing and Partition Guarantees](#routing-keys)

---

## Jackson JsonSerializer Configuration

In `application.yml`:
```yaml
spring:
  kafka:
    producer:
      bootstrap-servers: localhost:9092
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
      properties:
        spring.json.add.type.headers: true
```

---

## Creating Domain Event Records & Producer Service

```java
package com.example.event;

import java.math.BigDecimal;
import java.time.Instant;

public record OrderCreatedEvent(
    String orderId,
    String customerEmail,
    BigDecimal totalAmount,
    Instant timestamp
) {}
```

```java
package com.example.producer;

import com.example.event.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderJsonProducer {

    private static final Logger log = LoggerFactory.getLogger(OrderJsonProducer.class);
    private static final String TOPIC = "order-created-events";

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public OrderJsonProducer(KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishOrder(OrderCreatedEvent event) {
        log.info("Publishing JSON order event: {}", event);
        kafkaTemplate.send(TOPIC, event.orderId(), event)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        log.info("Message sent successfully to offset: {}", result.getRecordMetadata().offset());
                    } else {
                        log.error("Failed to send message: {}", ex.getMessage());
                    }
                });
    }
}
```

---

## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Kafka Consumer with @KafkaListener](../02-kafka-consumer/README.md) | [📚 Module Index](../README.md) | [Consuming JSON Messages with Spring Kafka →](../04-consume-json-messages/README.md) |
