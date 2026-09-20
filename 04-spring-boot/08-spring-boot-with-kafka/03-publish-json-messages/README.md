# មេរៀនទី ៣: ការផ្ញើ JSON Messages តាមរយៈ Kafka (Publishing JSON Messages)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../02-kafka-consumer/README.md) | [មេរៀនបន្ទាប់ →](../04-consume-json-messages/README.md)

> 📂 **កូដគំរូជាក់ស្តែង (Runnable Example Project):**  
> 👉 **គម្រោងពេញលេញ:** [Publish JSON Events via KafkaTemplate](../../examples/04-kafka-messaging)  
> 📄 **File កូដជាក់ស្តែង:** [`OrderEventProducer.java`](../../examples/04-kafka-messaging/src/main/java/com/example/kafka/producer/OrderEventProducer.java) | [`OrderCreatedEvent.java`](../../examples/04-kafka-messaging/src/main/java/com/example/kafka/event/OrderCreatedEvent.java) | [`application.yml`](../../examples/04-kafka-messaging/src/main/resources/application.yml)


---

## មាតិកា (Table of Contents)
1. [ហេតុអ្វីត្រូវប្រើ JSON នៅក្នុង Event-Driven Systems?](#ហេតុអ្វីត្រូវប្រើ-json)
2. [Jackson JsonSerializer Configuration](#jackson-jsonserializer)
3. [ការបង្កើត Model / Event Record](#ការបង្កើត-model)
4. [ការបង្កើត Generic Kafka Producer Service](#ការបង្កើត-kafka-producer)
5. [ការគ្រប់គ្រង Routing Key & Partitioning](#routing-key)

---

## Jackson JsonSerializer Configuration

នៅក្នុង `application.yml`៖
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

## ការបង្កើត Event Record & Producer Service

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
        // ប្រើ orderId ជា Message Key ដើម្បីធានា Order Partition Affiliation
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

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការបង្កើត Kafka Consumer ជាមួយ @KafkaListener (Kafka Consumer in Spring Boot)](../02-kafka-consumer/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការទទួល និង Parse JSON Messages ពី Kafka (Consuming JSON Messages) →](../04-consume-json-messages/README.md) |
