# Part 6: What Is IoC?

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)

![What is IoC?](./assets/what-do-you-mean-by-ioc.jpg "What do you mean by IoC (Inversion of Control)")

## Table of Contents

- [1. Definition of Inversion of Control (IoC)](#1-definition-of-inversion-of-control-ioc)
- [2. The Hollywood Principle](#2-the-hollywood-principle)
- [3. Traditional Control vs. Inverted Control](#3-traditional-control-vs-inverted-control)
- [4. Role of the Spring IoC Container](#4-role-of-the-spring-ioc-container)
- [5. 3 Ways to Provide Metadata to IoC Container](#5-3-ways-to-provide-metadata-to-ioc-container)

---

## 1. Definition of Inversion of Control (IoC)

**Inversion of Control (IoC)** is a core software architectural principle in which the control of object creation, configuration, and lifecycle management is transferred from manual developer instantiation to a dedicated runtime framework—the **IoC Container**.

In the Spring Framework, the IoC Container is responsible for:
1. Instantiating classes into **Spring Beans**.
2. Wiring dependencies between beans via **Dependency Injection (DI)**.
3. Managing the complete lifecycle of beans from initialization to destruction.

---

## 2. The Hollywood Principle

IoC is famously described by the **Hollywood Principle**:
> *"Don't call us, we'll call you."*

- **In traditional programming:** Your class acts as the active controller. When it needs a collaborator, it explicitly calls `new Collaborator()`.
- **In Spring IoC:** Your class expresses what it needs (via constructor arguments or fields), and the Spring container supplies the instance when the component is assembled.

---

## 3. Traditional Control vs. Inverted Control

```
[Traditional Control - Hardcoded Coupling]
OrderService ───> calls new PaymentService() directly

[Inverted Control - Container Assembly]
┌───────────────────────────┐
│   Spring IoC Container    │
│   - Creates PaymentService│
│   - Creates OrderService  │
│   - Wires them together   │
└─────────────┬─────────────┘
              │ Injected
              ▼
         OrderService (Loosely coupled)
```

---

## 4. Role of the Spring IoC Container

The IoC Container operates as an **enterprise object assembler**:
1. **Reads Configuration Metadata:** Parses instructions provided via XML, Java configuration, or annotations.
2. **Instantiates POJOs:** Produces instances of your Plain Old Java Objects.
3. **Assembles Components:** Injects appropriate collaborator instances, resulting in a fully configured application ready for execution.

---

## 5. 3 Ways to Provide Metadata to IoC Container

- **1. XML-Based Configuration:** Defining beans and properties in XML documents (e.g., `beans.xml`).
- **2. Annotation-Based Configuration:** Annotating classes with `@Component`, `@Service`, `@Repository`, `@Autowired`.
- **3. Java-Based Configuration:** Type-safe configuration classes annotated with `@Configuration` and factory methods annotated with `@Bean`.

---

## 🧭 Lesson Navigation

| Previous | Main Index | Next |
| :--- | :---: | :--- |
| [← Part 5: Versions of Spring](../05-versions-of-spring/README.md) | [📚 Spring Framework Index](../README.md) | [Part 7: Types of IoC Containers →](../07-types-of-ioc-container/README.md) |
