# Part 3: Features of Spring

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)

![Features of Spring](./assets/what-are-the-features-of-spring.jpg "What are the features of Spring")

## Table of Contents

- [1. Overview of Spring Features](#1-overview-of-spring-features)
- [2. The 6 Feature Groups](#2-the-6-feature-groups)
- [3. Feature Breakdown Table](#3-feature-breakdown-table)

---

## 1. Overview of Spring Features

The **Spring Framework** provides an end-to-end programming model for modern enterprise applications. Its capabilities are organized into six major functional pillars, spanning from the foundational IoC container to reactive web and messaging.

---

## 2. The 6 Feature Groups

### 1. Core Technologies
The backbone of the framework:
- **Dependency Injection (DI) & IoC Container:** Object lifecycle and dependency wiring.
- **AOP (Aspect-Oriented Programming):** Decoupling cross-cutting concerns (logging, security, transactions).
- **Events & Resources:** Application event publishing and generic resource loading.
- **I18n (Internationalization):** Localized message resolution.
- **Validation, Data Binding & Type Conversion:** Form/JSON mapping and validation.
- **SpEL (Spring Expression Language):** Powerful runtime expression evaluation.

### 2. Testing
- **Mock Objects:** Mocks for HTTP requests, servlets, and environmental beans.
- **TestContext Framework:** Seamless Spring container caching during unit and integration test runs.
- **Spring MVC Test:** Fluid test execution of controllers without running a real web server.
- **WebTestClient:** Non-blocking reactive testing for WebFlux endpoints.

### 3. Data Access & Persistence
- **Declarative Transactions:** Transparent transaction demarcation with `@Transactional`.
- **DAO Support:** Consistent, unchecked `DataAccessException` hierarchy.
- **JDBC & ORM:** Seamless integration with Hibernate, JPA, and MyBatis.
- **Object-XML Mapping (OXM):** Marshalling and unmarshalling XML structures.

### 4. Web Frameworks
- **Spring MVC:** Model-View-Controller framework built on the Servlet API for classic REST APIs and web apps.
- **Spring WebFlux:** Asynchronous, reactive, non-blocking web framework for event-driven systems.

### 5. Integration
- **JMS & AMQP:** Message-oriented middleware integration (RabbitMQ, Kafka, ActiveMQ).
- **Email Support:** Simple email dispatching via `JavaMailSender`.
- **Tasks & Scheduling:** Declarative background jobs using `@Async` and `@Scheduled`.
- **Cache Abstraction:** Unified caching APIs supporting Redis, Caffeine, and Hazelcast.
- **JMX & JCA:** Enterprise systems monitoring and legacy connection architecture.

### 6. Languages
- Beyond Java, Spring provides first-class support for **Kotlin** (coroutines, null-safety extensions) and **Groovy**.

---

## 3. Feature Breakdown Table

| Pillar | Core Capabilities | Real-World Developer Value |
| :--- | :--- | :--- |
| **Core** | IoC, DI, AOP, SpEL | Manages bean lifecycle and decouples modules |
| **Data Access** | JDBC, JPA, Transactions | Simplifies database operations and guarantees ACID compliance |
| **Web** | Spring MVC, WebFlux | Builds scalable RESTful APIs and microservices |
| **Testing** | Mockito, SpringBootTest | Ensures high test coverage with minimal boilerplate |
| **Integration** | Redis, RabbitMQ, Scheduling | Powers event-driven and background batch jobs |

---

## 🧭 Lesson Navigation

| Previous | Main Index | Next |
| :--- | :---: | :--- |
| [← Part 2: Advantages of Spring](../02-advantages-of-spring/README.md) | [📚 Spring Framework Index](../README.md) | [Part 4: Spring Modules Architecture →](../04-modules-of-spring/README.md) |
