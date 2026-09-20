# Lesson 6: Consuming String Messages from Kafka

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../05-publish-string-messages/README.md) | [Next Lesson →](../07-create-configure-topics/README.md)

---

## Table of Contents
1. [Overview](#overview)
2. [StringDeserializer Configuration](#stringdeserializer-configuration)
3. [Implementing String Listener](#implementing-string-listener)
4. [Batch Consumption for High Throughput](#batch-consumption)

---

## String Consumer Implementation

```java
package com.example.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StringKafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(StringKafkaConsumer.class);

    @KafkaListener(topics = "notifications-topic", groupId = "notification-group")
    public void consumeNotification(String message) {
        log.info("Received notification: {}", message);
    }
}
```

---

## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Publishing String Messages with Kafka](../05-publish-string-messages/README.md) | [📚 Module Index](../README.md) | [Creating and Configuring Kafka Topics Programmatically →](../07-create-configure-topics/README.md) |
