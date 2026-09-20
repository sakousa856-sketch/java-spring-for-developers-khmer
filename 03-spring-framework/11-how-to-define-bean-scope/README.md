# Part 11: Defining Bean Scopes

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)

![How to Define Bean Scope](./assets/how-to-define-the-scope-of-a-bean.jpg "How to Define the Scope of a Bean")

## Table of Contents

- [1. What Is a Bean Scope?](#1-what-is-a-bean-scope)
- [2. How to Declare Bean Scopes in Code](#2-how-to-declare-bean-scopes-in-code)
- [3. The 6 Available Spring Bean Scopes](#3-the-6-available-spring-bean-scopes)
- [4. Scope Overview Table](#4-scope-overview-table)

---

## 1. What Is a Bean Scope?

A **Bean Scope** defines the lifecycle, visibility, and instance creation strategy of a bean within the Spring IoC Container:
- Does the container maintain a single shared instance throughout the application runtime?
- Or should a fresh instance be produced every time a collaborator requests it?
- Or should instances be tied to incoming web requests or user sessions?

---

## 2. How to Declare Bean Scopes in Code

You have two primary ways to declare bean scopes:

### Option 1: `@Scope` Annotation (Java / Spring Boot)

```java
// On a component class
@Component
@Scope("prototype")
public class ReportGenerator {
    // A fresh instance created on each request
}

// On a @Bean method inside a @Configuration class
@Configuration
public class AppConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public NotificationService notificationService() {
        return new NotificationService();
    }
}
```

### Option 2: XML `scope` Attribute

```xml
<bean id="reportGenerator" class="com.example.ReportGenerator" scope="prototype"/>
```

---

## 3. The 6 Available Spring Bean Scopes

Spring provides 6 out-of-the-box scopes (2 universal scopes and 4 web-aware scopes):

1. **`singleton` (Default):** Scopes a single bean definition to a single object instance per Spring IoC Container.
2. **`prototype`:** Scopes a single bean definition to any number of object instances (new instance on every injection or `getBean()` invocation).
3. **`request` (Web Only):** Scopes a single bean definition to the lifecycle of a single **HTTP request**.
4. **`session` (Web Only):** Scopes a single bean definition to the lifecycle of an **HTTP session**.
5. **`application` (Web Only):** Scopes a single bean definition to the lifecycle of a **`ServletContext`**.
6. **`websocket` (Web Only):** Scopes a single bean definition to the lifecycle of a **WebSocket session**.

---

## 4. Scope Overview Table

| Scope | Supported Context | Creation Strategy |
| :--- | :--- | :--- |
| **`singleton`** | Universal | **Exactly 1 shared instance** per container (Default) |
| **`prototype`** | Universal | **Multiple** (new instance per lookup/injection) |
| **`request`** | Web-aware | 1 per incoming **HTTP Request** |
| **`session`** | Web-aware | 1 per active **HTTP Session** |
| **`application`** | Web-aware | 1 per **ServletContext** |

---

## 🧭 Lesson Navigation

| Previous | Main Index | Next |
| :--- | :---: | :--- |
| [← Part 10: What Is a Spring Bean?](../10-what-is-a-spring-bean/README.md) | [📚 Spring Framework Index](../README.md) | [Part 12: Default Bean Scope in Spring →](../12-default-bean-scope/README.md) |
