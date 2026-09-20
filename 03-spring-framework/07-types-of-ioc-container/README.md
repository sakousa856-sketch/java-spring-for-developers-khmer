# Part 7: Types of IoC Containers

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)

![Types of IoC Container](./assets/what-are-the-types-of-ioc-container-in-spring.jpg "What are the types of IOC container in spring")

## Table of Contents

- [1. The Two Primary Spring IoC Containers](#1-the-two-primary-spring-ioc-containers)
- [2. Understanding BeanFactory](#2-understanding-beanfactory)
- [3. Understanding ApplicationContext](#3-understanding-applicationcontext)
- [4. Comparison Table: BeanFactory vs ApplicationContext](#4-comparison-table-beanfactory-vs-applicationcontext)
- [5. Common ApplicationContext Implementations](#5-common-applicationcontext-implementations)

---

## 1. The Two Primary Spring IoC Containers

The Spring Framework provides two core container interfaces:

1. **`BeanFactory`** — The lightweight, fundamental container interface.
2. **`ApplicationContext`** — The advanced enterprise-grade container interface.

```
        ┌──────────────────┐
        │   BeanFactory    │  (Basic IoC & DI)
        └────────┬─────────┘
                 │ extends
                 ▼
        ┌──────────────────┐
        │ApplicationContext│  (AOP, I18n, Events, Web)
        └──────────────────┘
```

---

## 2. Understanding BeanFactory

`org.springframework.beans.factory.BeanFactory` is the root interface for accessing the Spring bean registry:
- Provides basic methods for dependency injection and bean retrieval (`getBean()`).
- **Lazy Initialization:** Beans are not instantiated on startup; instead, they are created only when explicitly requested via `getBean()`.
- **Target Use Case:** Highly resource-constrained environments (e.g., embedded devices or legacy mobile applications). Rarely used in modern web engineering.

---

## 3. Understanding ApplicationContext

`org.springframework.context.ApplicationContext` inherits from `BeanFactory` and incorporates a full suite of enterprise services:
- **Eager Pre-instantiation:** Pre-creates all singleton beans at startup, allowing configuration errors to be caught immediately (Fail-Fast behavior).
- **AOP Integration:** Automatic registration of aspect proxies and interceptors.
- **Message Resolution (I18n):** Built-in support for internationalization through `MessageSource`.
- **Event Publication:** Native decoupled application event routing via `ApplicationEventPublisher`.
- **Environment Abstraction:** Profiles and environment-specific property resolution.

---

## 4. Comparison Table: BeanFactory vs ApplicationContext

| Attribute | `BeanFactory` | `ApplicationContext` |
| :--- | :--- | :--- |
| **Bean Instantiation** | **Lazy** (on demand) | **Eager** (at application startup) |
| **Enterprise Services** | Basic | Complete (AOP, I18n, Transactions) |
| **Event Routing** | Not supported | Fully supported (`ApplicationEvent`) |
| **Industry Adoption** | Rarely used directly | **Standard choice (100% in Spring Boot)** |

---

## 5. Common ApplicationContext Implementations

1. **`AnnotationConfigApplicationContext`:** Loads standalone configurations directly from classes annotated with `@Configuration`.
2. **`ClassPathXmlApplicationContext`:** Resolves XML configuration files located on the application classpath.
3. **`AnnotationConfigServletWebServerApplicationContext`:** The default web application container created automatically by **Spring Boot**.

---

## 🧭 Lesson Navigation

| Previous | Main Index | Next |
| :--- | :---: | :--- |
| [← Part 6: What Is IoC?](../06-what-is-ioc/README.md) | [📚 Spring Framework Index](../README.md) | [Part 8: Spring Configuration File →](../08-spring-configuration-file/README.md) |
