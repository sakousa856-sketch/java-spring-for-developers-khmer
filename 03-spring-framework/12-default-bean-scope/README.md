# Part 12: Default Bean Scope in Spring

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)

![Default Bean Scope in Spring](./assets/what-is-the-default-bean-scope-in-spring-framework.jpg "What Is the Default Bean Scope in Spring Framework")

## Table of Contents

- [1. The Default Bean Scope Value](#1-the-default-bean-scope-value)
- [2. Why Spring Selects Singleton by Default](#2-why-spring-selects-singleton-by-default)
- [3. Code Comparison](#3-code-comparison)
- [4. Crucial Consideration: Thread Safety](#4-crucial-consideration-thread-safety)

---

## 1. The Default Bean Scope Value

In the **Spring Framework**, if you omit the `@Scope` annotation on a bean definition:
> **The default scope assigned to any Spring Bean is `singleton`.**

This means that for any `@Component`, `@Service`, `@Repository`, or `@Bean`, the Spring IoC Container creates and maintains exactly **one shared instance per container definition**. Every injection or lookup returns a reference to that single cached instance.

---

## 2. Why Spring Selects Singleton by Default

Spring defaults to `singleton` for three foundational engineering reasons:

1. **Extreme Memory Efficiency:**
   - In a high-traffic web application processing thousands of concurrent HTTP requests, creating new service and repository instances per request would rapidly degrade memory and trigger severe Garbage Collection pauses.
2. **Superior Performance:**
   - Singleton beans are eagerly created during container bootstrap. Runtime requests execute immediately without incurring allocation overhead.
3. **Stateless Service Model:**
   - Enterprise backend services, DAOs, and controllers are overwhelmingly **stateless**; therefore, sharing a single instance across worker threads is optimal.

---

## 3. Code Comparison

Both snippets below are functionally identical:

```java
// Option 1: Implicit default (Clean, standard Spring Boot convention)
@Service
public class PaymentService {
    // Automatically registered as a singleton bean
}

// Option 2: Explicit declaration
@Service
@Scope("singleton")
public class PaymentService {
    // Explicitly registered as a singleton bean
}
```

---

## 4. Crucial Consideration: Thread Safety

> ⚠️ **Critical Developer Warning:**
> Because a singleton bean is shared concurrently across multiple HTTP request threads (e.g., Tomcat worker threads):
> - **Never maintain mutable state or user-specific data in instance variables of a singleton bean!**
> - Singleton beans must always remain **stateless**—confining dynamic data strictly to method arguments or local method variables.

---

## 🧭 Lesson Navigation

| Previous | Main Index | Next |
| :--- | :---: | :--- |
| [← Part 11: Defining Bean Scopes](../11-how-to-define-bean-scope/README.md) | [📚 Spring Framework Index](../README.md) | [Part 13: Singleton Scope Deep Dive →](../13-singleton-scope/README.md) |
