# Lesson 2: Deep Dive into Dependency Injection (DI)

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../01-inversion-of-control/README.md) | [Next Lesson →](../03-beanfactory-vs-applicationcontext/README.md)

> 📂 **Runnable Example Project:**  
> 👉 **Complete Project:** [Bookstore REST API (Constructor Injection)](../../examples/01-rest-api-crud)  
> 📄 **Source Code Files:** [`BookController.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/controller/BookController.java) | [`BookService.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/service/BookService.java)


## Table of Contents

- [1. What is Dependency Injection (DI)?](#1-what-is-dependency-injection-di)
- [2. The 3 Flavors of Dependency Injection](#2-the-3-flavors-of-dependency-injection)
- [3. Why Constructor Injection is the Industry Benchmark](#3-why-constructor-injection-is-the-industry-benchmark)
- [4. Production Code Implementation](#4-production-code-implementation)
- [5. Summary](#5-summary)

---

## 1. What is Dependency Injection (DI)?

**Dependency Injection (DI)** is the concrete design pattern realizing Inversion of Control. A "dependency" is an object collaborator required by a client class. "Injection" is the passing of that dependency into the client by a separate entity (the injector).

---

## 2. The 3 Flavors of Dependency Injection

| Injection Pattern | Syntax Form | Evaluation |
| :--- | :--- | :--- |
| **1. Constructor Injection** | Injected via class constructor arguments | ⭐⭐⭐⭐⭐ **(Recommended Standard)** |
| **2. Setter Injection** | Injected via public setter methods | ⭐⭐⭐ (Optional dependencies only) |
| **3. Field Injection** | Annotating private fields with `@Autowired` | ⚠️ **(Anti-pattern to avoid)** |

---

## 3. Why Constructor Injection is the Industry Benchmark

1. **Immutability:** Facilitates assigning fields to `final`, ensuring thread-safe immutability after construction.
2. **Frictionless Unit Testing:** Allows straightforward instantiation in tests (`new OrderService(mockRepo)`) without reflection utilities or running Spring contexts.
3. **Fail-Fast Safety:** Compilers enforce dependency provisioning at compile time, eliminating latent runtime `NullPointerException`s.

---

## 4. Production Code Implementation

```java
package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // 1. Immutable final dependency
    private final UserRepository userRepository;

    // 2. Explicit constructor injection (implicit @Autowired in Spring 4.3+)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserName(Long id) {
        return userRepository.findById(id).map(User::getName).orElse("Unknown");
    }
}
```

---

## 5. Summary

- DI externalizes component dependency resolution.
- Enforce **Constructor Injection** paired with `private final` fields across all enterprise services.

---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Understanding Inversion of Control (IoC)](../01-inversion-of-control/README.md) | [📚 Module Index](../README.md) | [BeanFactory vs ApplicationContext Comparison →](../03-beanfactory-vs-applicationcontext/README.md) |
