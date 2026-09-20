# មេរៀនទី ៩: ការបង្កើត Dynamic Kafka Listener Endpoint (Dynamic Kafka Listener Registration)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../08-kafka-elasticsearch-grafana/README.md) | [មេរៀនបន្ទាប់ →](../../09-spring-boot-with-aop/01-aop-introduction/README.md)

---

## មាតិកា (Table of Contents)
1. [តើអ្វីទៅជា Dynamic Kafka Listener?](#តើអ្វីទៅជា-dynamic-kafka-listener)
2. [KafkaListenerEndpointRegistry Overview](#kafkalistenerendpointregistry)
3. [ការបញ្ជា Start, Stop, និង Pause Listener Containers](#ការបញ្ជា-start-stop)
4. [ការចុះឈ្មោះ Topic Listener ថ្មីនៅ Runtime](#ការចុះឈ្មោះ-runtime)

---

## ការបញ្ជា Listener តាមរយៈ KafkaListenerEndpointRegistry

យើងអាចបញ្ជា Stop/Start ឬ Pause/Resume Kafka Listener នៅ Runtime តាមរយៈ REST API ឧទាហរណ៍ ពេល Maintenance System៖

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

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការតាមដាន Kafka Metrics ជាមួយ Elasticsearch និង Grafana (Kafka Observability)](../08-kafka-elasticsearch-grafana/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការគ្រប់គ្រង Cross-Cutting Concerns ជាមួយ Aspect-Oriented Programming (AOP) →](../../09-spring-boot-with-aop/01-aop-introduction/README.md) |
