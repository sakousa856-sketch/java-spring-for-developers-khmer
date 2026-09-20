# Part 14: What Is Dependency Injection?

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)

![What is Dependency Injection?](./assets/what-do-you-mean-by-di.jpg "What do you mean by Dependency Injection")

## Table of Contents

- [1. Definition of Dependency Injection (DI)](#1-definition-of-dependency-injection-di)
- [2. The 3 Types of Dependency Injection in Spring](#2-the-3-types-of-dependency-injection-in-spring)
- [3. Code Examples for Each Injection Strategy](#3-code-examples-for-each-injection-strategy)
- [4. Core Benefits of Dependency Injection](#4-core-benefits-of-dependency-injection)

---

## 1. Definition of Dependency Injection (DI)

**Dependency Injection (DI)** is a specialized design pattern implementing the broader principle of **Inversion of Control (IoC)**.

- **Dependency:** An object, service, or repository that another class requires to perform its domain operations (e.g., `OrderService` requires `PaymentService`).
- **Injection:** The act of passing (supplying) the required collaborator instance to the dependent class, rather than forcing the dependent class to instantiate it via `new`.

> **Role of Spring DI:** The IoC container automatically resolves matching beans registered in the container and passes them into target components via annotations like `@Autowired` or configuration metadata.

---

## 2. The 3 Types of Dependency Injection in Spring

The Spring Framework provides 3 distinct injection patterns:

1. **Constructor Injection:** Supplying dependencies through parameter arguments of the class constructor.
2. **Setter Injection:** Supplying dependencies by invoking traditional setter methods (`set...()`).
3. **Field Injection:** Injecting dependencies directly into private fields using reflection and `@Autowired`.

---

## 3. Code Examples for Each Injection Strategy

### 1. Constructor Injection (Recommended Best Practice)

```java
@Service
public class OrderService {

    private final PaymentService paymentService;

    // As of Spring 4.3+, @Autowired is optional on single-constructor classes
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
```

### 2. Setter Injection (Ideal for Optional Dependencies)

```java
@Service
public class OrderService {

    private NotificationService notificationService;

    @Autowired
    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
}
```

### 3. Field Injection (Not Recommended for Production)

```java
@Service
public class OrderService {

    // Direct reflection injection onto private fields
    @Autowired
    private PaymentService paymentService;
}
```

---

## 4. Core Benefits of Dependency Injection

1. **Loose Coupling:** Components depend upon interface abstractions rather than hardcoded concrete classes.
2. **Effortless Unit Testing:** Collaborators can easily be substituted with mocks (e.g., via Mockito) without spinning up heavyweight servers.
3. **Clean Architecture:** Aligns directly with the **SOLID** principles, particularly the Dependency Inversion Principle (DIP).

---

## 🧭 Lesson Navigation

| Previous | Main Index | Next |
| :--- | :---: | :--- |
| [← Part 13: Singleton Scope Deep Dive](../13-singleton-scope/README.md) | [📚 Spring Framework Index](../README.md) | [Part 15: Constructor vs Setter Injection →](../15-constructor-vs-setter-injection/README.md) |
