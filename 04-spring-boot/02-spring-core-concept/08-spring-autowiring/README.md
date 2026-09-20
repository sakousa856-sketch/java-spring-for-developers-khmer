# Lesson 8: Autowiring in Spring with @Autowired

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../07-create-spring-bean-3-ways/README.md) | [Next Lesson →](../09-dispatcherservlet/README.md)

> 📂 **Runnable Example Project:**  
> 👉 **Complete Project:** [Bookstore REST API (Service Injection)](../../examples/01-rest-api-crud)  
> 📄 **Source Code Files:** [`BookController.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/controller/BookController.java) | [`BookService.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/service/BookService.java)


## Table of Contents

- [1. Autowiring Mechanics in Spring](#1-autowiring-mechanics-in-spring)
- [2. The Ambiguity Dilemma (`NoUniqueBeanDefinitionException`)](#2-the-ambiguity-dilemma)
- [3. Disambiguation with `@Primary` and `@Qualifier`](#3-disambiguation-with-primary-and-qualifier)
- [4. Summary](#4-summary)

---

## 1. Autowiring Mechanics in Spring

Spring resolves dependencies declared on constructors or fields automatically using type-driven lookup.

---

## 2. The Ambiguity Dilemma

When an interface (e.g., `PaymentGateway`) possesses multiple candidate implementations (`StripePayment` and `PaypalPayment`):
```java
@Service
public class CheckoutService {
    // Throws NoUniqueBeanDefinitionException because candidate resolution is ambiguous
    public CheckoutService(PaymentGateway paymentGateway) { ... }
}
```

---

## 3. Disambiguation with `@Primary` and `@Qualifier`

### Approach 1: `@Primary` (Default Precedence)
```java
@Component
@Primary
public class StripePayment implements PaymentGateway {}
```

### Approach 2: `@Qualifier` (Explicit Bean Targeting)
```java
@Service
public class CheckoutService {
    public CheckoutService(@Qualifier("paypalPayment") PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
}
```

---

## 4. Summary

- Spring resolves autowired dependencies primarily by type.
- Resolve ambiguity using `@Primary` for defaults and `@Qualifier` for explicit named binding.

---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← ](../07-create-spring-bean-3-ways/README.md) | [📚 Module Index](../README.md) | [ →](../09-dispatcherservlet/README.md) |
