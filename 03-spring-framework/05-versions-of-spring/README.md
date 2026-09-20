# Part 5: Versions of Spring

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)

![Overview of versions of Spring Framework](./assets/overview-of-versions-of-spring.jpg "Overview of versions of Spring Framework")

## Table of Contents

- [1. The Evolution of Spring](#1-the-evolution-of-spring)
- [2. Major Version Milestones (1.0 to 6.0)](#2-major-version-milestones-10-to-60)
- [3. Version Milestones Table](#3-version-milestones-table)
- [4. Key Takeaways for Spring 6.0+](#4-key-takeaways-for-spring-60)

---

## 1. The Evolution of Spring

First created by [Rod Johnson](https://en.wikipedia.org/wiki/Rod_Johnson_(programmer)) in 2003, the **Spring Framework** has continuously adapted over two decades to lead the enterprise Java landscape—pioneering annotations, REST, microservices, and reactive programming.

---

## 2. Major Version Milestones (1.0 to 6.0)

- **Spring 0.9 (2003):** Initial incarnation derived from the code examples in Rod Johnson's book.
- **Spring 1.0 (March 24, 2004):** First official production release (1.0 GA), predominantly focused on XML configurations.
- **Spring 2.0 (October 2006):** Introduced custom XML namespaces and native AspectJ support.
- **Spring 2.5 (November 2007):** Revolutionary release introducing **Annotations** (`@Component`, `@Autowired`, `@Service`, `@Repository`), dramatically reducing XML dependency.
- **Spring 3.0 (December 2009):** Introduced the **Spring Expression Language (SpEL)**, Java-based configuration (`@Configuration`, `@Bean`), environment profiles, and first-class RESTful web support.
- **Spring 4.0 (December 2013):** Added full support for **Java 8** (Lambdas, Date/Time API), WebSocket capabilities, and conditional bean registration paving the way for **Spring Boot**.
- **Spring 5.0 (2017):** Major release bringing **Spring WebFlux** (reactive programming via Project Reactor), seamless **Kotlin** integration, and an HTTP/2 foundation.
- **Spring 6.0 (November 22, 2022):** Generational leap requiring **Java 17+** as the minimum baseline, migrating packages to **`jakarta.*` (Jakarta EE 9+)**, and enabling **Ahead-of-Time (AOT)** compilation with **GraalVM Native Images** for instant startup and low memory footprints.

---

## 3. Version Milestones Table

| Version | Release Year | Min Java Version | Key Innovations |
| :--- | :--- | :--- | :--- |
| **Spring 1.0** | 2004 | Java 1.3 / 1.4 | Core IoC Container, XML Bean Definition |
| **Spring 2.5** | 2007 | Java 5 | Annotation-driven configuration (`@Autowired`) |
| **Spring 3.0** | 2009 | Java 5 / 6 | SpEL, Java-based Configuration, REST APIs |
| **Spring 4.0** | 2013 | Java 8 | Java 8 features, WebSockets, Conditional beans |
| **Spring 5.0** | 2017 | Java 8+ | Reactive WebFlux, Kotlin support, HTTP/2 |
| **Spring 6.0** | 2022 | **Java 17+** | Jakarta EE 9+, GraalVM Native Image, AOT Engine |

---

## 4. Key Takeaways for Spring 6.0+

When developing modern applications with **Spring Boot 3.x** and **Spring 6.x**:
1. **Java Baseline:** Java 17 or Java 21 LTS is strictly required.
2. **Jakarta Namespace:** All imports previously in `javax.servlet.*`, `javax.persistence.*`, and `javax.validation.*` are now under `jakarta.*`.

---

## 🧭 Lesson Navigation

| Previous | Main Index | Next |
| :--- | :---: | :--- |
| [← Part 4: Spring Modules Architecture](../04-modules-of-spring/README.md) | [📚 Spring Framework Index](../README.md) | [Part 6: What Is IoC? →](../06-what-is-ioc/README.md) |
