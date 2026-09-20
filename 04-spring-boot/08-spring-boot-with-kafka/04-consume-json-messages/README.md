# មេរៀនទី ៤: ការទទួល និង Parse JSON Messages ពី Kafka (Consuming JSON Messages)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../03-publish-json-messages/README.md) | [មេរៀនបន្ទាប់ →](../05-publish-string-messages/README.md)

> 📂 **កូដគំរូជាក់ស្តែង (Runnable Example Project):**  
> 👉 **គម្រោងពេញលេញ:** [Consume JSON Events via @KafkaListener](../../examples/04-kafka-messaging)  
> 📄 **File កូដជាក់ស្តែង:** [`OrderEventConsumer.java`](../../examples/04-kafka-messaging/src/main/java/com/example/kafka/consumer/OrderEventConsumer.java) | [`OrderCreatedEvent.java`](../../examples/04-kafka-messaging/src/main/java/com/example/kafka/event/OrderCreatedEvent.java) | [`application.yml`](../../examples/04-kafka-messaging/src/main/resources/application.yml)


---

## មាតិកា (Table of Contents)
1. [ដំណើរការ JSON Deserialization របស់ Spring Kafka](#ដំណើរការ-json-deserialization)
2. [Consumer Configuration (JsonDeserializer & Trusted Packages)](#consumer-configuration)
3. [ការបង្កើត Type-safe @KafkaListener Method](#ការបង្កើត-kafkalistener)
4. [ការដោះស្រាយបញ្ហា Serialization Mismatch](#ការដោះស្រាយបញ្ហា)

---

## Consumer Configuration ជាមួយ Trusted Packages

នៅក្នុង `application.yml`៖
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

## ការបង្កើត Type-safe @KafkaListener

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
        
        // កាត់បន្ថយស្តុកទំនិញ...
    }
}
```

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការផ្ញើ JSON Messages តាមរយៈ Kafka (Publishing JSON Messages)](../03-publish-json-messages/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការផ្ញើ String Messages ទៅកាន់ Kafka (Publishing String Messages) →](../05-publish-string-messages/README.md) |
