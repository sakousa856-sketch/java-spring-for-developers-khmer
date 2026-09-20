# មេរៀនទី ៧: ការត្រួតពិនិត្យសុខភាពប្រព័ន្ធ និង Monitoring ជាមួយ Spring Boot Actuator
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../06-yaml-configuration/README.md) | [មេរៀនបន្ទាប់ →](../08-spring-boot-devtools/README.md)

## មាតិកា (Table of Contents)

- [1. ស្វែងយល់អំពី Production Readiness និង Spring Boot Actuator](#1-ស្វែងយល់អំពី-production-readiness-និង-spring-boot-actuator)
- [2. ការដំឡើង Starter `spring-boot-starter-actuator`](#2-ការដំឡើង-starter-spring-boot-starter-actuator)
- [3. Actuator Endpoints សំខាន់ៗ (`/health`, `/metrics`, `/info`)](#3-actuator-endpoints-សំខាន់ៗ-health-metrics-info)
- [4. ការបើក និងលាក់ Endpoints (Security & Exposing)](#4-ការបើក-និងលាក់-endpoints-security--exposing)
- [5. ការបង្កើត Custom Health Indicator](#5-ការបង្កើត-custom-health-indicator)
- [6. ការតភ្ជាប់ជាមួយ Prometheus & Grafana តាមរយៈ Micrometer](#6-ការតភ្ជាប់ជាមួយ-prometheus--grafana-តាមរយៈ-micrometer)
- [7. សង្ខេប](#7-សង្ខេប)

---

## 1. ស្វែងយល់អំពី Production Readiness និង Spring Boot Actuator

នៅពេលយកកម្មវិធីទៅដាក់លើ Production ក្នុង Cloud (Kubernetes, AWS, Docker) ការសរសេរកូដឱ្យដើរត្រឹមត្រូវមិនទាន់គ្រប់គ្រាន់ឡើយ។ ក្រុមការងារ DevOps/SRE ត្រូវការដឹងថា៖
- តើ Application កំពុងរស់នៅល្អ (Healthy) ឬគាំង (Deadlock)?
- តើ Database នៅភ្ជាប់ល្អ ឬដាច់?
- តើ Memory (JVM Heap) និង CPU កំពុងប្រើអស់ប៉ុន្មានភាគរយ?
- តើក្នុងមួយវិនាទីមាន HTTP Requests ចូលមកប៉ុន្មានដង?

**Spring Boot Actuator** ផ្តល់នូវ Production-ready features ទាំងនេះភ្លាមៗដោយមិនបាច់សរសេរកូដច្រើនឡើយ។

---

## 2. ការដំឡើង Starter `spring-boot-starter-actuator`

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>

</dependency>
```

---

## 3. Actuator Endpoints សំខាន់ៗ

| Endpoint | ព័ត៌មានដែលផ្តល់ជូន |
| :--- | :--- |
| **`/actuator/health`** | បង្ហាញស្ថានភាពសុខភាពកម្មវិធី (`UP`, `DOWN`) ប្រើសម្រាប់ Kubernetes Liveness & Readiness Probes |
| **`/actuator/info`** | បង្ហាញព័ត៌មានទូទៅអំពី Version, Git Commit, និង Developer Contact |
| **`/actuator/metrics`** | បង្ហាញទិន្នន័យស្ថិតិដូចជា JVM Memory, Garbage Collection, HTTP Response Times |
| **`/actuator/env`** | បង្ហាញ Environment Properties របស់ប្រព័ន្ធ |
| **`/actuator/beans`** | បង្ហាញបញ្ជី Spring Beans ទាំងអស់ដែលបានចុះឈ្មោះក្នុង IoC Container |

---

## 4. ការបើក និងលាក់ Endpoints (Security & Exposing)

តាមលំនាំដើមដើម្បីសុវត្ថិភាព មានតែ `/actuator/health` មួយគត់ដែលត្រូវបានបើកបង្ហាញ។ យើងអាចកំណត់ក្នុង `application.yml` ដើម្បីបើក Endpoints ផ្សេងៗ និងបង្ហាញព័ត៌មានលម្អិតនៃ Health Check៖

```yaml
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus # បើកតែ endpoints ដែលចាំបាច់
  endpoint:
    health:
      show-details: always # បង្ហាញស្ថានភាព Database, Disk Space, Redis លម្អិត
```

> 🛡️ **ការការពារសុវត្ថិភាព Production:**
> ដាច់ខាតកុំប្រើ `include: "*"` លើ Production ឱ្យសោះ ព្រោះ Endpoints ដូចជា `/env` ឬ `/heapdump` អាចលេចធ្លាយ Password និង Secret Keys ទៅកាន់ពិភពខាងក្រៅ។ ត្រូវការពារ `/actuator` ជាមួយ Spring Security ជានិច្ច!

---

## 5. ការបង្កើត Custom Health Indicator

ពេលខ្លះយើងចង់ត្រួតពិនិត្យសុវត្ថិភាពនៃ Third-party API ឬ External Payment Gateway ផ្ទាល់ខ្លួន៖

```java
package com.example.demo.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean isGatewayUp = checkExternalPaymentGateway();

        if (isGatewayUp) {
            return Health.up()
                    .withDetail("GatewayService", "Wing/ABA Payment Gateway")
                    .withDetail("responseTimeMs", 42)
                    .build();
        }

        return Health.down()
                .withDetail("GatewayService", "Wing/ABA Payment Gateway")
                .withDetail("error", "Timeout: មិនអាចភ្ជាប់ទៅកាន់ Gateway បានឡើយ")
                .build();
    }

    private boolean checkExternalPaymentGateway() {
        // Mock checking connection
        return true; 
    }
}
```

---

## 6. ការតភ្ជាប់ជាមួយ Prometheus & Grafana តាមរយៈ Micrometer

Spring Boot Actuator រួមបញ្ចូល **Micrometer** ដែលជា Facade សម្រាប់ Metric Collection។ ដោយគ្រាន់តែបន្ថែម Dependency មួយទៀត៖

```xml
<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>

</dependency>
```

នោះ Endpoint `/actuator/prometheus` នឹងដំណើរការភ្លាមៗ។ Prometheus Server អាចទាញយក (Scrape) Metrics ទាំងនេះទៅបង្ហាញជាផ្ទាំង Dashboard ពណ៌ចម្រុះលើ **Grafana** បានយ៉ាងស្រស់ស្អាត!

---

## 7. សង្ខេប

- **Spring Boot Actuator** គឺជាឧបករណ៍មិនអាចខ្វះបានសម្រាប់ Production Observability។
- `/actuator/health` ដើរតួជាបេះដូងសម្រាប់ Kubernetes ក្នុងការត្រួតពិនិត្យថា Pods នៅរស់ឬស្លាប់។
- ប្រើ Custom `HealthIndicator` ដើម្បីតាមដានសេវាកម្មខាងក្រៅសំខាន់ៗ។
- ភ្ជាប់ជាមួយ **Micrometer & Prometheus** ដើម្បីតាមដាន Real-time Performance Metrics។


---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការកំណត់រចនាសម្ព័ន្ធជាមួយ YAML (YAML Configuration in Spring Boot)](../06-yaml-configuration/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [បង្កើនល្បឿនអភិវឌ្ឍន៍ជាមួយ Spring Boot DevTools (Developer Tools) →](../08-spring-boot-devtools/README.md) |
