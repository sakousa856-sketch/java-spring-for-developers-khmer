# Lesson 9: Dynamic Kafka Listener Endpoint Registration

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../08-kafka-elasticsearch-grafana/README.md) | [Next Lesson →](../../09-spring-boot-with-aop/01-aop-introduction/README.md)

---

## Table of Contents
1. [What is a Dynamic Kafka Listener?](#what-is-dynamic-listener)
2. [KafkaListenerEndpointRegistry Overview](#kafkalistenerendpointregistry)
3. [Pausing, Resuming, and Stopping Listeners at Runtime](#lifecycle-management)
4. [Registering Arbitrary Topics at Runtime](#runtime-topic-registration)

---

## Runtime Lifecycle Management via KafkaListenerEndpointRegistry

Dynamically control message listener containers via management REST endpoints during maintenance windows:

```java
package com.example.controller;

import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka/listeners")
public class KafkaListenerLifecycleController {

    private final KafkaListenerEndpointRegistry registry;

    public KafkaListenerLifecycleController(KafkaListenerEndpointRegistry registry) {
        this.registry = registry;
    }

    @PostMapping("/{listenerId}/pause")
    public String pauseListener(@PathVariable String listenerId) {
        MessageListenerContainer container = registry.getListenerContainer(listenerId);
        if (container != null) {
            container.pause();
            return "Listener " + listenerId + " paused successfully.";
        }
        return "Listener not found: " + listenerId;
    }

    @PostMapping("/{listenerId}/resume")
    public String resumeListener(@PathVariable String listenerId) {
        MessageListenerContainer container = registry.getListenerContainer(listenerId);
        if (container != null) {
            container.resume();
            return "Listener " + listenerId + " resumed successfully.";
        }
        return "Listener not found: " + listenerId;
    }
}
```

---

## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Kafka Observability with Elasticsearch, Prometheus, and Grafana](../08-kafka-elasticsearch-grafana/README.md) | [📚 Module Index](../README.md) | [Managing Cross-Cutting Concerns with Aspect-Oriented Programming (AOP) →](../../09-spring-boot-with-aop/01-aop-introduction/README.md) |
