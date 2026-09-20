# Part 20: Spring Expression Language (SpEL Fundamentals)

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)
> 
> 📖 **Official Spring Documentation:** [Spring Expression Language (SpEL)](https://docs.spring.io/spring-framework/reference/core/expressions.html)

![Spring Expression Language](./assets/spring-expression-language-spel.svg "Spring Expression Language: Syntax & Operations")

## Table of Contents

- [1. SpEL Overview: #{...} vs ${...}](#1-spel-overview--vs-)
- [2. Arithmetic, Relational & Logical Evaluation](#2-arithmetic-relational--logical-evaluation)
- [3. Method Invocation & Safe Navigation Operator (?.)](#3-method-invocation--safe-navigation-operator-)
- [4. The Elvis Operator (?:) for Fallback Values](#4-the-elvis-operator--for-fallback-values)
- [5. Collection Selection (.?[...]) & Projection (.![...])](#5-collection-selection--and-projection-)
- [6. Practical Code Challenge](#6-practical-code-challenge)
- [🔗 Official Spring Documentation](#-official-spring-documentation)

---

## 1. SpEL Overview: #{...} vs ${...}

The **Spring Expression Language (SpEL)** provides dynamic runtime query and object-graph manipulation within the Spring ecosystem.

| Syntax | Mechanism | Purpose | Example |
| :--- | :--- | :--- | :--- |
| **`${...}`** | **Property Placeholder** | Evaluates static key-values from property sources | `@Value("${app.port}")` |
| **`#{...}`** | **SpEL Expression** | Evaluates runtime dynamic logic, methods & computations | `@Value("#{2 * T(java.lang.Math).PI}")` |

---

## 2. Arithmetic, Relational & Logical Evaluation

```java
@Component
public class ArithmeticDemo {

    @Value("#{10 + 20 * 2}")
    private int computedResult; // 50

    @Value("#{T(java.lang.Math).sqrt(256)}")
    private double squareRoot; // 16.0

    @Value("#{systemProperties['user.timezone'] != null}")
    private boolean hasTimezone;
}
```

---

## 3. Method Invocation & Safe Navigation Operator (?.)

Calling standard Java methods dynamically and protecting against `NullPointerException`:

```java
@Component
public class CustomerFormatter {

    @Value("#{'enterprise backend'.toUpperCase()}")
    private String uppercaseTitle;

    // Safe navigation avoids NPE if customer.getAddress() evaluates to null
    @Value("#{customer.address?.postalCode}")
    private String zip;
}
```

---

## 4. The Elvis Operator (?:) for Fallback Values

Derived from Groovy and Kotlin, the Elvis operator safely provides a fallback for null properties:

```java
@Component
public class UserGreeting {

    @Value("#{user.nickname ?: 'Valued Customer'}")
    private String greetingTarget;
}
```

---

## 5. Collection Selection (.?[...]) & Projection (.![...])

SpEL offers built-in filtering (Selection) and transformation (Projection) on iterable structures:

```java
@Component
public class StoreAnalytics {

    // Filter collection for products whose price exceeds 100
    @Value("#{inventory.products.?[price > 100]}")
    private List<Product> premiumItems;

    // Transform collection of products into a list of SKU codes
    @Value("#{inventory.products.![skuCode]}")
    private List<String> catalogSkus;
}
```

---

## 6. Practical Code Challenge

**Challenge:** Write a SpEL expression in `@Value` to calculate a discounted price: if `order.total` is greater than 200, apply a 15% discount (`order.total * 0.85`), otherwise apply full price.

<details>
<summary>🔍 Click to view solution</summary>

```java
@Component
public class PricingCalculator {

    @Value("#{order.total > 200 ? order.total * 0.85 : order.total}")
    private double finalPrice;

    public double getFinalPrice() {
        return finalPrice;
    }
}
```
</details>

---

## 🔗 Official Spring Documentation

- [Spring Expression Language (SpEL) Reference](https://docs.spring.io/spring-framework/reference/core/expressions.html)
- [SpEL Evaluation in Bean Definitions](https://docs.spring.io/spring-framework/reference/core/expressions/beandef.html)
- [SpEL Language Reference Operators](https://docs.spring.io/spring-framework/reference/core/expressions/language-ref.html)

---

## 🧭 Lesson Navigation

| Previous | Main Index | Next |
| :--- | :---: | :--- |
| [← Part 19: Core Annotations & Environment Properties](../19-core-annotations-and-properties/README.md) | [📚 Spring Framework Index](../README.md) | [Part 21: Spring Application Events →](../21-spring-application-events/README.md) |
