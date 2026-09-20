# Lesson 4: Spring Tool Suite (STS) Project Setup

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../03-spring-mvc-vs-spring-boot/README.md) | [Next Lesson →](../05-eclipse-ide-setup/README.md)

## Table of Contents

- [1. About Spring Tool Suite 4 (STS)](#1-about-spring-tool-suite-4-sts)
- [2. Downloading and Installing STS](#2-downloading-and-installing-sts)
- [3. Scaffolding a Spring Boot Project in STS](#3-scaffolding-a-spring-boot-project-in-sts)
- [4. Verification and Execution](#4-verification-and-execution)
- [5. Summary](#5-summary)

---

## 1. About Spring Tool Suite 4 (STS)

**Spring Tool Suite 4 (STS)** is the official Eclipse-powered IDE curated by VMware for Spring Boot development. It features specialized language servers, dynamic annotation indexing, and the Spring Boot Dashboard.

---

## 2. Downloading and Installing STS

1. Navigate to official download portal: `https://spring.io/tools`
2. Select target OS binary package (macOS ARM/x64, Linux, or Windows)
3. Unpack and launch the IDE binary

---

## 3. Scaffolding a Spring Boot Project in STS

1. Select **File -> New -> Spring Starter Project**
2. Populate project attributes:
   - **Project Name:** `demo-sts-app`
   - **Build System:** Maven
   - **JDK Platform:** Java 17+ (LTS)
   - **Packaging:** JAR
3. Attach starter dependencies:
   - **Spring Web**
   - **Spring Boot DevTools**
4. Click **Finish** to bootstrap the workspace.

---

## 4. Verification and Execution

- Right-click `DemoStsAppApplication.java` -> **Run As -> Spring Boot App**
- Inspect console output verifying embedded Tomcat initialization on default port `8080`.

---

## 5. Summary

- STS delivers an official, free, specialized development environment tailored for Spring applications.



---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Spring MVC vs Spring Boot Comparison](../03-spring-mvc-vs-spring-boot/README.md) | [📚 Module Index](../README.md) | [Eclipse IDE Setup for Spring Boot →](../05-eclipse-ide-setup/README.md) |
