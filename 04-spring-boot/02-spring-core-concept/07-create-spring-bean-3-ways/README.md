# Lesson 7: 07-create-spring-bean-3-ways

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../06-custom-bean-scope/README.md) | [Next Lesson →](../08-spring-autowiring/README.md)

## Table of Contents

- [1. Approach 1: Stereotype Component Scanning](#1-approach-1-stereotype-component-scanning)
- [2. Approach 2: Java `@Configuration` and `@Bean`](#2-approach-2-java-configuration-and-bean)
- [3. Approach 3: XML Configuration (Legacy)](#3-approach-3-xml-configuration-legacy)
- [4. Comparative Selection Matrix](#4-comparative-selection-matrix)
- [5. Summary](#5-summary)

---

## 1. Approach 1: Stereotype Component Scanning

Standard for application source code under your control:
```java
@Service // Or @Component, @Repository, @Controller
public class InvoiceService {}
```

---

## 2. Approach 2: Java `@Configuration` and `@Bean`

Mandatory pattern for third-party classes outside your compilation boundary where source code cannot be directly annotated:
```java
@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
```

---

## 3. Approach 3: XML Configuration (Legacy)

```xml
<bean id="accountService" class="com.example.service.AccountServiceImpl" />
```

---

## 4. Comparative Selection Matrix

| Strategy | Ideal Use Case | Key Strength |
| :--- | :--- | :--- |
| **Stereotypes (`@Component`)** | Internal application domain classes | Zero configuration overhead |
| **Java Config (`@Bean`)** | External third-party libraries | Maximum programmatic flexibility |
| **XML Descriptors** | Legacy enterprise maintenance | Codebase decoupling |

---

## 5. Summary

- Annotate your internal classes with `@Service` or `@Component`.
- Instantiate external third-party classes inside `@Configuration` methods annotated with `@Bean`.



---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← ](../06-custom-bean-scope/README.md) | [📚 Module Index](../README.md) | [Autowiring in Spring with @Autowired →](../08-spring-autowiring/README.md) |
