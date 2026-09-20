# Lesson 7: Production Readiness & Observability with Spring Boot Actuator

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../06-yaml-configuration/README.md) | [Next Lesson →](../08-spring-boot-devtools/README.md)

## Table of Contents

- [1. Production Readiness and the Role of Actuator](#1-production-readiness-and-the-role-of-actuator)
- [2. Adding the `spring-boot-starter-actuator` Dependency](#2-adding-the-spring-boot-starter-actuator-dependency)
- [3. Key Actuator Endpoints (`/health`, `/metrics`, `/info`)](#3-key-actuator-endpoints-health-metrics-info)
- [4. Exposing and Securing Endpoints](#4-exposing-and-securing-endpoints)
- [5. Implementing Custom Health Indicators](#5-implementing-custom-health-indicators)
- [6. Integrating Prometheus & Grafana via Micrometer](#6-integrating-prometheus--grafana-via-micrometer)
- [7. Summary](#7-summary)

---

## 1. Production Readiness and the Role of Actuator

Deploying microservices into enterprise cloud topologies (Kubernetes, AWS ECS, Docker Swarms) requires visibility beyond clean business logic. SRE and DevOps teams require telemetry answering:
- Is the service process alive or deadlocked?
- Are downstream database and cache sockets active or severed?
- What are the current JVM Heap memory pressure and garbage collection overheads?
- What is the ingress HTTP request throughput and p99 latency?

**Spring Boot Actuator** furnishes built-in production telemetry endpoints out of the box with zero boilerplate instrumentation.

---

## 2. Adding the `spring-boot-starter-actuator` Dependency

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

---

## 3. Key Actuator Endpoints

| Endpoint | Telemetry Provided |
| :--- | :--- |
| **`/actuator/health`** | Basic/detailed service vitality (`UP`, `DOWN`), used by Kubernetes Liveness & Readiness probes |
| **`/actuator/info`** | Operational metadata (version numbers, git commit hashes, maintainer contacts) |
| **`/actuator/metrics`** | Detailed operational indicators (JVM memory pools, thread dumps, HTTP request latency) |
| **`/actuator/env`** | Current runtime environment properties and active profiles |
| **`/actuator/beans`** | Complete registry of managed Spring beans initialized in the ApplicationContext |

---

## 4. Exposing and Securing Endpoints

By default, only `/actuator/health` is exposed over HTTP for security reasons. Fine-tune endpoint exposure and health inspection depth in `application.yml`:

```yaml
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus # Expose strictly needed endpoints
  endpoint:
    health:
      show-details: always # Expose detailed diagnostic health for databases, disk space, and caches
```

> 🛡️ **Production Security Guardrail:**
> Never configure wildcard exposure (`include: "*"`) in production environments. Diagnostic endpoints like `/env` and `/heapdump` expose database credentials, environment secrets, and memory dumps. Always secure the `/actuator/**` path behind Spring Security.

---

## 5. Implementing Custom Health Indicators

Surface the health of critical external services (e.g., third-party payment gateways, specialized downstream APIs) directly within Spring's aggregate health status:

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
                .withDetail("error", "Socket Timeout: Unable to establish handshake with payment gateway")
                .build();
    }

    private boolean checkExternalPaymentGateway() {
        // Ping external payment gateway socket
        return true; 
    }
}
```

---

## 6. Integrating Prometheus & Grafana via Micrometer

Spring Boot Actuator integrates natively with **Micrometer**, the vendor-neutral metrics instrumentation facade. Include the Prometheus registry:

```xml
<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>
</dependency>
```

This immediately activates the `/actuator/prometheus` endpoint, allowing Prometheus scraper daemons to ingest application telemetry and visualize it inside rich **Grafana** dashboards.

---

## 7. Summary

- **Spring Boot Actuator** delivers out-of-the-box enterprise observability.
- `/actuator/health` coordinates Kubernetes pod lifecycle management (liveness and readiness checks).
- Implement custom `HealthIndicator` beans to monitor critical external dependencies.
- Bridge metrics to **Prometheus & Grafana** via Micrometer for real-time observability.


---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Configuration with YAML in Spring Boot](../06-yaml-configuration/README.md) | [📚 Module Index](../README.md) | [Accelerating Development with Spring Boot DevTools →](../08-spring-boot-devtools/README.md) |
