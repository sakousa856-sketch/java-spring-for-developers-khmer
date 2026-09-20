# Lesson 6: 06-custom-bean-scope

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../05-singleton-and-prototype-scopes/README.md) | [Next Lesson →](../07-create-spring-bean-3-ways/README.md)

## Table of Contents

- [1. Motivations for Custom Scopes](#1-motivations-for-custom-scopes)
- [2. Implementing `org.springframework.beans.factory.config.Scope`](#2-implementing-scope)
- [3. Registering the Custom Scope in ApplicationContext](#3-registering-the-custom-scope-in-applicationcontext)
- [4. Summary](#4-summary)

---

## 1. Motivations for Custom Scopes

Beyond Singleton, Prototype, and Web Scopes (`request`, `session`), enterprise architectures occasionally mandate custom lifecycle boundaries, such as **TenantScope** for multi-tenant SaaS applications.

---

## 2. Implementing `Scope`

Implement the foundational Spring `Scope` interface:

```java
package com.example.demo.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import java.util.HashMap;
import java.util.Map;

public class SimpleThreadScope implements Scope {

    private final ThreadLocal<Map<String, Object>> threadScope =
            ThreadLocal.withInitial(HashMap::new);

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> scope = threadScope.get();
        return scope.computeIfAbsent(name, k -> objectFactory.getObject());
    }

    @Override
    public Object remove(String name) {
        return threadScope.get().remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {}

    @Override
    public Object resolveContextualObject(String key) { return null; }

    @Override
    public String getConversationId() { return Thread.currentThread().getName(); }
}
```

---

## 3. Registering the Custom Scope in ApplicationContext

```java
@Configuration
public class CustomScopeConfig {

    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("thread", new SimpleThreadScope());
        return configurer;
    }
}
```

---

## 4. Summary

- Implement Spring's `Scope` interface and register it via `CustomScopeConfigurer` to instantiate custom lifecycle strategies.



---
## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← ](../05-singleton-and-prototype-scopes/README.md) | [📚 Module Index](../README.md) | [ →](../07-create-spring-bean-3-ways/README.md) |
