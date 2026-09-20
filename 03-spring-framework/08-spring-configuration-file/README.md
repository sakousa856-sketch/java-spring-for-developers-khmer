# Part 8: Spring Configuration File

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)

![Spring Configuration File](./assets/what-is-a-spring-configuration-file.jpg "What is a Spring configuration file")

## Table of Contents

- [1. What Is a Spring Configuration File?](#1-what-is-a-spring-configuration-file)
- [2. Structure of an XML Configuration File](#2-structure-of-an-xml-configuration-file)
- [3. Loading Configuration in Java](#3-loading-configuration-in-java)
- [4. Evolution toward Modern JavaConfig](#4-evolution-toward-modern-javaconfig)

---

## 1. What Is a Spring Configuration File?

A **Spring Configuration File** is an external configuration file (conventionally formatted in **XML**, such as `beans.xml` or `applicationContext.xml`) that provides the **configuration metadata** consumed by the Spring IoC Container:
1. **Class Registrations:** Declares which classes should be instantiated as Spring Beans.
2. **Inter-Bean Collaborations:** Details how beans relate to and depend upon each other.
3. **Property Configuration:** Injects static values or environment variables upon instantiation.

This represents the foundational **XML-Based Configuration** approach in the Spring Framework.

---

## 2. Structure of an XML Configuration File

An XML configuration file defines a top-level `<beans>` element containing nested `<bean>` declarations:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- 1. Define UserRepository Bean -->
    <bean id="userRepository" class="com.example.repository.UserRepositoryImpl" />

    <!-- 2. Define UserService Bean and wire repository dependency -->
    <bean id="userService" class="com.example.service.UserServiceImpl">
        <property name="userRepository" ref="userRepository" />
    </bean>

</beans>
```

- **`id` / `name`:** Unique identifier for the bean within the container.
- **`class`:** The fully qualified class name to instantiate.
- **`<property>`:** Injects collaborators via setter methods.
- **`<constructor-arg>`:** Passes arguments to class constructors.

---

## 3. Loading Configuration in Java

The Spring container reads this configuration using `ClassPathXmlApplicationContext`:

```java
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
UserService userService = context.getBean("userService", UserService.class);
```

---

## 4. Evolution toward Modern JavaConfig

While XML configuration was ubiquitous in early Spring versions (1.x–2.x), modern enterprise Spring applications have largely transitioned to:
- **Java-Based Configuration (`@Configuration` & `@Bean`)**: Providing compile-time type safety and effortless IDE refactoring.
- **Annotation-Driven Components (`@Component`, `@Autowired`)**: Enabled by automatic classpath scanning to eliminate manual bean definitions.

---

## 🧭 Lesson Navigation

| Previous | Main Index | Next |
| :--- | :---: | :--- |
| [← Part 7: Types of IoC Containers](../07-types-of-ioc-container/README.md) | [📚 Spring Framework Index](../README.md) | [Part 9: 3 Ways to Configure Spring →](../09-ways-to-configure-spring/README.md) |
