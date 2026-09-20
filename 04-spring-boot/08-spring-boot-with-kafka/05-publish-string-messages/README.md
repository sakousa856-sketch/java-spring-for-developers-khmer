# Lesson 5: Publishing String Messages with Kafka

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../04-consume-json-messages/README.md) | [Next Lesson →](../06-consume-string-messages/README.md)

---

## Table of Contents
1. [Use Cases for Plain Text and Raw String Payloads](#use-cases)
2. [StringSerializer Configuration](#stringserializer-configuration)
3. [Implementing the String Producer](#string-producer)
4. [Synchronous vs Asynchronous Dispatch](#sync-vs-async)

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

## Implementing the String Producer

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

## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Consuming JSON Messages with Spring Kafka](../04-consume-json-messages/README.md) | [📚 Module Index](../README.md) | [Consuming String Messages from Kafka →](../06-consume-string-messages/README.md) |
