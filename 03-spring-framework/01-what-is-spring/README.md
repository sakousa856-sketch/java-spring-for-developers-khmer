# Part 1: What Is Spring Framework?

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)

![What is Spring?](./assets/what-is-spring.jpg "What is Spring?")

## Table of Contents

- [1. Definition of Spring Framework](#1-definition-of-spring-framework)
- [2. History & Origins](#2-history--origins)
- [3. Why Spring Dominates Java Backend Development](#3-why-spring-dominates-java-backend-development)
- [4. Core Philosophy](#4-core-philosophy)

---

## 1. Definition of Spring Framework

The **Spring Framework** is an enterprise-grade, open-source application framework for Java that introduces automated lifecycle and instance management of application classes (known as **Spring Beans**).

- Its core capabilities can be used to build any standalone Java application, from desktop utilities to high-throughput backend services.
- In modern software engineering, Spring is primarily used to build scalable **Enterprise Web Applications** and **RESTful Microservices**.
- Distributed under the Apache 2.0 open-source license, Spring provides comprehensive infrastructure support, enabling developers to build robust Java systems faster, cleaner, and with maintainable architecture.

---

## 2. History & Origins

- The Spring Framework was originally created by **Rod Johnson** (an Australian software architect and musician).
- In 2002, Rod Johnson published his influential book, *"Expert One-on-One J2EE Design and Development"*, offering an alternative to the cumbersome, over-engineered Java 2 Enterprise Edition (J2EE) specifications—particularly Enterprise JavaBeans (EJB).
- The practical code designs and concepts introduced in the book resonated strongly with developers, prompting collaboration to turn it into an open-source framework named **Spring** (symbolizing a fresh start after the "winter" of traditional J2EE).
- Spring was officially released as version 1.0 in **June 2003**.

---

## 3. Why Spring Dominates Java Backend Development

| Comparison Area | Traditional Java / J2EE Approach | Spring Framework Solution |
| :--- | :--- | :--- |
| **Object Instantiation** | Manual `new Class()` across the codebase | Managed centrally by the **IoC Container** |
| **Component Coupling** | Tight coupling (hard to modify or swap) | **Loose coupling** via Dependency Injection |
| **Unit Testing** | Painful to mock dependencies | Easy mocking and isolated unit testing |
| **Boilerplate Code** | Repetitive database and transaction code | Declarative templates (`JdbcTemplate`, `@Transactional`) |

---

## 4. Core Philosophy

Spring's overarching design philosophy is **Non-Invasive Architecture**:
1. **POJO-Based:** Your business components do not need to implement vendor-specific Spring interfaces or inherit framework classes—they remain Plain Old Java Objects (POJOs).
2. **Separation of Concerns:** Spring handles cross-cutting infrastructure (database connectivity, transactions, security, and logging), allowing developers to focus purely on domain logic.

---

## 🧭 Lesson Navigation

| Previous | Main Index | Next |
| :--- | :---: | :--- |
| [← Previous Course: Advance Java](../../02-advance-java/18-interfaces/README.md) | [📚 Spring Framework Index](../README.md) | [Part 2: Advantages of Spring →](../02-advantages-of-spring/README.md) |
