# Lesson 5: 05-singleton-and-prototype-scopes

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../04-spring-bean-lifecycle/README.md) | [Next Lesson →](../06-custom-bean-scope/README.md)

## Table of Contents

- [1. Defining Bean Scopes](#1-defining-bean-scopes)
- [2. Singleton vs Prototype Matrix](#2-singleton-vs-prototype-matrix)
- [3. The Prototype-in-Singleton Injection Dilemma](#3-the-prototype-in-singleton-injection-dilemma)
- [4. Summary](#4-summary)

---

## 1. Defining Bean Scopes

Bean Scopes dictate the lifecycle span and instantiation cardinality of managed objects inside the Spring ApplicationContext.

---

## 2. Singleton vs Prototype Matrix

| Metric | Singleton Scope (Default) | Prototype Scope |
| :--- | :--- | :--- |
| **Cardinality** | Exactly **one instance** per IoC container | **A new instance** created for each lookup/injection |
| **Destruction Lifecycle** | Managed completely by Spring | Discarded by Spring after instantiation (`@PreDestroy` not called) |
| **State Mutability** | Stateless across concurrent threads | Stateful instance isolation |

```java
// 1. Singleton (Default)
@Service
public class PaymentService {}

// 2. Prototype
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShoppingCart {}
```

---

## 3. The Prototype-in-Singleton Injection Dilemma

Injecting a prototype bean into a singleton service injects the prototype collaborator exactly once during singleton construction, inadvertently turning the prototype into a singleton reference!
👉 **Remedy:** Utilize **`@Lookup` methods** or Spring's **`ObjectProvider<T>`** to request fresh instances on demand.

---

## 4. Summary

- Singleton is Spring's default scope, optimized for thread-safe, stateless service architectures.
- Prototype is reserved for stateful beans requiring distinct lifecycle isolation.



---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Spring Bean Lifecycle Deep Dive](../04-spring-bean-lifecycle/README.md) | [📚 Module Index](../README.md) | [ →](../06-custom-bean-scope/README.md) |
