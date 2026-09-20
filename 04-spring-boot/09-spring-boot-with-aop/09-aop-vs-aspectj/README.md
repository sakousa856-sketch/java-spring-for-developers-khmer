# Lesson 9: Spring AOP vs AspectJ

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../08-aop-vs-oop/README.md) | [Next Lesson →](../../10-spring-boot-testing/01-unit-testing-junit/README.md)

---

## Table of Contents
1. [Introduction](#introduction)
2. [Proxy-based Interception vs Bytecode Weaving](#mechanisms)
3. [Comprehensive Comparison Matrix](#comparison-matrix)
4. [Decision Framework: Which to Use?](#decision-framework)

---

## Comprehensive Comparison Matrix

| Feature | Spring AOP | AspectJ |
| :--- | :--- | :--- |
| **Design Goal** | Lightweight AOP coupled with Spring IoC | Comprehensive standalone AOP language |
| **Implementation** | Dynamic Runtime Proxies (JDK / CGLIB) | Bytecode Weaving (Compile-time, Load-time) |
| **Join Point Support** | Method Execution only | Field, Constructor, Method, Exception |
| **Performance** | Modest runtime proxy overhead | High execution speed (Direct bytecode) |
| **Tooling Burden** | Zero additional compiler requirements | Requires AspectJ compiler (`ajc`) or Java agent |

---

## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← AOP vs OOP (Aspect-Oriented vs Object-Oriented Programming)](../08-aop-vs-oop/README.md) | [📚 Module Index](../README.md) | [Unit Testing Spring Boot Applications with JUnit 5 & AssertJ →](../../10-spring-boot-testing/01-unit-testing-junit/README.md) |
