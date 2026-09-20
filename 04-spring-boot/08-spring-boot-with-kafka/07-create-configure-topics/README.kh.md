# មេរៀនទី ៧: ការបង្កើត និងកំណត់រចនាសម្ព័ន្ធ Topics ដោយស្វ័យប្រវត្តិ (Programmatic Topic Configuration)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)  
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.kh.md) | [← មេរៀនមុន](../06-consume-string-messages/README.kh.md) | [មេរៀនបន្ទាប់ →](../08-kafka-elasticsearch-grafana/README.kh.md)

> 📂 **កូដគំរូជាក់ស្តែង (Runnable Example Project):**  
> 👉 **គម្រោងពេញលេញ:** [Kafka Docker Compose & Topic Setup](../../examples/04-kafka-messaging)  
> 📄 **File កូដជាក់ស្តែង:** [`docker-compose.yml`](../../examples/04-kafka-messaging/docker-compose.yml) | [`application.yml`](../../examples/04-kafka-messaging/src/main/resources/application.yml)


---

## មាតិកា (Table of Contents)
1. [KafkaAdmin និង NewTopic Bean](#kafkaadmin-និង-newtopic)
2. [ការកំណត់ Partitions និង Replication Factor](#ការកំណត់-partitions)
3. [ការកំណត់ Retention Period និង Compaction Policy](#ការកំណត់-retention)
4. [TopicBuilder Fluent API](#topicbuilder-fluent-api)

---

## TopicBuilder Configuration

Spring Boot ផ្តល់ `TopicBuilder` ដើម្បីចុះឈ្មោះ Topic ស្វ័យប្រវត្តិនៅពេល Application ចាប់ផ្តើមដំណើរការ៖

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
                .partitions(5)               // 5 Partitions
                .replicas(3)                 // Replication Factor of 3 (Cluster HA)
                .config("retention.ms", "604800000") // 7 ថ្ងៃ
                .build();
    }

    @Bean
    public NewTopic notificationTopic() {
        return TopicBuilder.name("notifications")
                .partitions(3)
                .replicas(1)
                .compact()                  // Log Compaction
                .build();
    }
}
```

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការទទួល String Messages ពី Kafka (Consuming String Messages)](../06-consume-string-messages/README.kh.md) | [📚 បញ្ជីមេរៀន Module](../README.kh.md) | [ការតាមដាន Kafka Metrics ជាមួយ Elasticsearch និង Grafana (Kafka Observability) →](../08-kafka-elasticsearch-grafana/README.kh.md) |
