# Lesson 7: Creating and Configuring Kafka Topics Programmatically

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../06-consume-string-messages/README.md) | [Next Lesson →](../08-kafka-elasticsearch-grafana/README.md)

> 📂 **Runnable Example Project:**  
> 👉 **Complete Project:** [Kafka Docker Compose & Topic Setup](../../examples/04-kafka-messaging)  
> 📄 **Source Code Files:** [`docker-compose.yml`](../../examples/04-kafka-messaging/docker-compose.yml) | [`application.yml`](../../examples/04-kafka-messaging/src/main/resources/application.yml)


---

## Table of Contents
1. [KafkaAdmin and NewTopic Beans](#kafkaadmin-and-newtopic)
2. [Configuring Partitions and Replication Factors](#partitions-and-replication)
3. [Retention Policies and Log Compaction](#retention-and-compaction)
4. [Using TopicBuilder Fluent API](#topicbuilder-fluent-api)

---

## TopicBuilder Configuration

Spring Boot provides `TopicBuilder` to declaratively instantiate topics upon startup:

```java
package com.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic orderEventsTopic() {
        return TopicBuilder.name("order-events")
                .partitions(5)
                .replicas(3)
                .config("retention.ms", "604800000") // 7 days
                .build();
    }

    @Bean
    public NewTopic notificationTopic() {
        return TopicBuilder.name("notifications")
                .partitions(3)
                .replicas(1)
                .compact()
                .build();
    }
}
```

---

## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Consuming String Messages from Kafka](../06-consume-string-messages/README.md) | [📚 Module Index](../README.md) | [Kafka Observability with Elasticsearch, Prometheus, and Grafana →](../08-kafka-elasticsearch-grafana/README.md) |
