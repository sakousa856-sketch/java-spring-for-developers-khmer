# មេរៀនទី ៥: ការផ្ញើ String Messages ទៅកាន់ Kafka (Publishing String Messages)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../04-consume-json-messages/README.md) | [មេរៀនបន្ទាប់ →](../06-consume-string-messages/README.md)

---

## មាតិកា (Table of Contents)
1. [ករណីប្រើប្រាស់ String Messages](#ករណីប្រើប្រាស់-string-messages)
2. [StringSerializer Configuration](#stringserializer-configuration)
3. [ការបង្កើត String Producer](#ការបង្កើត-string-producer)
4. [Synchronous vs Asynchronous Sending](#sync-vs-async)

---

## StringSerializer Configuration

```yaml
spring:
  kafka:
    producer:
      bootstrap-servers: localhost:9092
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
```

---

## ការបង្កើត String Producer

```java
package com.example.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StringKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public StringKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
```

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការទទួល និង Parse JSON Messages ពី Kafka (Consuming JSON Messages)](../04-consume-json-messages/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការទទួល String Messages ពី Kafka (Consuming String Messages) →](../06-consume-string-messages/README.md) |
