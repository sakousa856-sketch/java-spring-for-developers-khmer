# មេរៀនទី ៦: ការទទួល String Messages ពី Kafka (Consuming String Messages)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../05-publish-string-messages/README.md) | [មេរៀនបន្ទាប់ →](../07-create-configure-topics/README.md)

---

## មាតិកា (Table of Contents)
1. [សេចក្តីផ្តើម](#សេចក្តីផ្តើម)
2. [StringDeserializer Configuration](#stringdeserializer-configuration)
3. [ការបង្កើត String Listener](#ការបង្កើត-string-listener)
4. [Batch Consumption សម្រាប់ High Throughput](#batch-consumption)

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

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការផ្ញើ String Messages ទៅកាន់ Kafka (Publishing String Messages)](../05-publish-string-messages/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការបង្កើត និងកំណត់រចនាសម្ព័ន្ធ Topics ដោយស្វ័យប្រវត្តិ (Programmatic Topic Configuration) →](../07-create-configure-topics/README.md) |
