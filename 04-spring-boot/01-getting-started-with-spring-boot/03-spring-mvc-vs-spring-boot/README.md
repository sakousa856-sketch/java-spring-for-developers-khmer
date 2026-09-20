# Lesson 3: Spring MVC vs Spring Boot Comparison

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../02-spring-vs-spring-boot/README.md) | [Next Lesson →](../04-sts-project-setup/README.md)

## Table of Contents

- [1. Dissecting Spring MVC and Spring Boot](#1-dissecting-spring-mvc-and-spring-boot)
- [2. Comparative Architectural Matrix](#2-comparative-architectural-matrix)
- [3. How Spring Boot Embeds Spring MVC](#3-how-spring-boot-embeds-spring-mvc)
- [4. Summary](#4-summary)

---

## 1. Dissecting Spring MVC and Spring Boot

A classic technical interview distinction:
- **Spring MVC (Model-View-Controller):** A dedicated **presentation tier module** inside Spring Framework engineered for HTTP request dispatching, view resolution, and RESTful endpoint routing.
- **Spring Boot:** A comprehensive **application framework and runtime orchestrator** that bundles, auto-configures, and executes Spring components (including Spring MVC) out-of-the-box.

---

## 2. Comparative Architectural Matrix

| Metric | Spring MVC | Spring Boot |
| :--- | :--- | :--- |
| **Architectural Scope** | HTTP Presentation Layer (Web MVC) | Holistic Application Lifecycle Platform |
| **Server Requirements** | External Servlet Container (Tomcat / Jetty WAR) | Embedded Servlet Engine (Executable JAR) |
| **Deployment Artifact** | Standard Servlet WAR | Self-contained Executable JAR |
| **Relationship** | A modular sub-framework bundled inside Spring | The macro platform auto-configuring Spring MVC |

---

## 3. How Spring Boot Embeds Spring MVC

Declaring `spring-boot-starter-web` transitively imports **Spring MVC**, **Jackson**, and an embedded **Tomcat** instance. Spring Boot dynamically registers the `DispatcherServlet` without requiring legacy `web.xml` deployment descriptors.

---

## 4. Summary

- Spring MVC governs web request semantics, controllers, and JSON marshaling.
- Spring Boot automates the underlying container infrastructure and runtime wiring.



---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Spring Framework vs Spring Boot Comparison](../02-spring-vs-spring-boot/README.md) | [📚 Module Index](../README.md) | [Spring Tool Suite (STS) Project Setup →](../04-sts-project-setup/README.md) |
