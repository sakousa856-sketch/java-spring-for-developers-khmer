# Lesson 1: Introduction to Spring Boot

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../README.md) | [Next Lesson →](../02-spring-vs-spring-boot/README.md)

## Table of Contents

- [1. Definition of Spring Boot](#1-definition-of-spring-boot)
- [2. Why Spring Boot Was Created](#2-why-spring-boot-was-created)
- [3. The 4 Pillars of Spring Boot](#3-the-4-pillars-of-spring-boot)
- [4. Comparison Table: Spring Framework vs. Spring Boot](#4-comparison-table-spring-framework-vs-spring-boot)
- [5. Minimal Spring Boot Example](#5-minimal-spring-boot-example)

---

## 1. Definition of Spring Boot

**Spring Boot** is an opinionated, production-ready framework built directly on top of the **Spring Framework**, designed to streamline and accelerate the development of standalone microservices and web applications with minimal configuration.

Its core operating philosophy is:
> **"Convention over Configuration"**
> (Spring Boot provides sensible, battle-tested defaults for libraries and configurations, freeing developers to focus purely on business logic).

---

## 2. Why Spring Boot Was Created

In the era of traditional **Spring Framework**, creating a new project was notoriously laborious:
- Writing verbose XML configurations or verbose Java config files
- Manually resolving JAR dependency version conflicts
- Installing and configuring external servlet containers (e.g., standalone Apache Tomcat) to deploy `.war` files
- Repetitive boilerplate setup for datasources, view resolvers, and dispatchers

**Spring Boot** eliminates these pain points entirely, allowing developers to scaffold and launch a production-grade application in **seconds**.

---

## 3. The 4 Pillars of Spring Boot

1. **Auto-Configuration:**
   - Spring Boot scans your classpath and automatically configures beans based on detected libraries (e.g., detecting MySQL drivers automatically instantiates a `DataSource`).
2. **Starter Dependencies:**
   - Aggregated dependency descriptors (e.g., `spring-boot-starter-web`) bring in all compatible dependencies without manual version management.
3. **Embedded Web Servers:**
   - Ships with embedded **Tomcat**, **Jetty**, or **Undertow** inside a self-contained executable JAR. Run simply via `java -jar app.jar`.
4. **Spring Boot Actuator:**
   - Provides turnkey endpoints for production health checks (`/actuator/health`), application metrics, and thread dumps out of the box.

---

## 4. Comparison Table: Spring Framework vs. Spring Boot

| Feature Area | Spring Framework | Spring Boot |
| :--- | :--- | :--- |
| **Primary Goal** | Enterprise IoC, DI, and modular architecture | Radically fast application bootstrapping |
| **Configuration** | Manual XML or `@Configuration` classes | **Automatic convention-based configuration** |
| **Server Deployment** | External WAR deployment to standalone server | **Embedded server inside self-executing JAR** |
| **Dependency Management** | Manual version pairing across dependencies | Curated **Starters and Bill of Materials (BOM)** |
| **Operational Telemetry** | Manual custom health probes | **Built-in Spring Boot Actuator** |

---

## 5. Minimal Spring Boot Example

A single class creates a fully operational HTTP REST service:

```java
@SpringBootApplication
@RestController
public class Application {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```


---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Module Index](../README.md) | [📚 Module Index](../README.md) | [Spring Framework vs Spring Boot Comparison →](../02-spring-vs-spring-boot/README.md) |
