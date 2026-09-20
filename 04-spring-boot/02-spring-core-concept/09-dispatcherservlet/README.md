# Lesson 9: 09-dispatcherservlet

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../08-spring-autowiring/README.md) | [Next Lesson →](../10-build-tools-maven-gradle/README.md)

## Table of Contents

- [1. The Front Controller Architectural Pattern](#1-the-front-controller-architectural-pattern)
- [2. Complete Request Lifecycle in DispatcherServlet](#2-complete-request-lifecycle)
- [3. Core Collaborators (HandlerMapping, HandlerAdapter)](#3-core-collaborators)
- [4. Summary](#4-summary)

---

## 1. The Front Controller Architectural Pattern

**`DispatcherServlet`** serves as the central front controller gateway intercepting all inbound HTTP requests in Spring Web applications.

```mermaid
flowchart TD
    Client["Client (Browser / API Consumer)"] -->|1. HTTP Request| DS["DispatcherServlet (Front Controller)"]
    DS -->|2. Route Lookup| HM["HandlerMapping"]
    HM -->|3. Resolved Handler| DS
    DS -->|4. Invoke Handler| HA["HandlerAdapter"]
    HA -->|5. Execute Handler Method| Ctrl["@RestController / Controller"]
    Ctrl -->|6. Return Response Data| HA
    HA -->|7. Serialized Payload| DS
    DS -->|8. HTTP Response Body| Client
```

---

## 2. Core Collaborators

1. **`HandlerMapping`:** Evaluates incoming request URIs against mapped `@RequestMapping` routes.
2. **`HandlerAdapter`:** Handles parameter resolution (`@PathVariable`, `@RequestBody`) and invokes the target controller method.
3. **`HttpMessageConverter` (Jackson):** Serializes Java return objects into JSON response streams.

---

## 3. Summary

- `DispatcherServlet` acts as the single point of entry coordinating HTTP request lifecycles.



---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Autowiring in Spring with @Autowired](../08-spring-autowiring/README.md) | [📚 Module Index](../README.md) | [Build Tools in Spring: Maven and Gradle →](../10-build-tools-maven-gradle/README.md) |
