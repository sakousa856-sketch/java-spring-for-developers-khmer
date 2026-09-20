# Lesson 3: BeanFactory vs ApplicationContext Comparison

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../02-dependency-injection/README.md) | [Next Lesson →](../04-spring-bean-lifecycle/README.md)

## Table of Contents

- [1. Spring IoC Container Hierarchy](#1-spring-ioc-container-hierarchy)
- [2. Detailed Comparative Analysis](#2-detailed-comparative-analysis)
- [3. Lazy vs Eager Instantiation Mechanics](#3-lazy-vs-eager-instantiation-mechanics)
- [4. Summary](#4-summary)

---

## 1. Spring IoC Container Hierarchy

Spring exposes two fundamental container interfaces:
```
       BeanFactory (Foundational Root Interface)
               ▲
               │ extends
      ApplicationContext (Enterprise Container Interface)
```

---

## 2. Detailed Comparative Analysis

| Dimension | `BeanFactory` | `ApplicationContext` |
| :--- | :--- | :--- |
| **Abstraction Level** | Lightweight basic container | Full-featured enterprise container |
| **Bean Instantiation** | **Lazy:** Instantiates beans upon explicit `getBean()` lookup | **Eager:** Pre-instantiates all singletons during startup |
| **AOP Integration** | Requires manual programmatic proxies | Native declarative AOP support |
| **Event Broadcasting** | Unsupported | Integrated via `ApplicationEventPublisher` |
| **Internationalization** | Unsupported | Native message bundle resolution (`MessageSource`) |
| **Recommended Usage** | Ultra-constrained memory environments (IoT devices) | **All standard enterprise applications and Spring Boot** |

---

## 3. Lazy vs Eager Instantiation Mechanics

- **BeanFactory (Lazy):** Minimizes initial heap allocation. However, syntax errors and missing dependencies remain undetected until runtime invocation occurs.
- **ApplicationContext (Eager):** Enforces a fail-fast guarantee. Invalid dependencies or broken wiring halt application bootstrap immediately, preventing broken deployments from reaching production clusters.

---

## 4. Summary

- Spring Boot uniformly standardizes upon **`ApplicationContext`** implementations (such as `AnnotationConfigServletWebServerApplicationContext`).



---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Deep Dive into Dependency Injection (DI)](../02-dependency-injection/README.md) | [📚 Module Index](../README.md) | [Spring Bean Lifecycle Deep Dive →](../04-spring-bean-lifecycle/README.md) |
