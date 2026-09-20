# មេរៀនទី ៦: 06-custom-bean-scope

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)  
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.kh.md) | [← មេរៀនមុន](../05-singleton-and-prototype-scopes/README.kh.md) | [មេរៀនបន្ទាប់ →](../07-create-spring-bean-3-ways/README.kh.md)

## មាតិកា (Table of Contents)

- [1. ហេតុអ្វីបានជាត្រូវមាន Custom Scope?](#1-ហេតុអ្វីបានជាត្រូវមាន-custom-scope)
- [2. ការ Implement Interface `org.springframework.beans.factory.config.Scope`](#2-ការ-implement-interface-scope)
- [3. ការចុះឈ្មោះ Custom Scope ក្នុង Container](#3-ការចុះឈ្មោះ-custom-scope-ក្នុង-container)
- [4. សង្ខេប](#4-សង្ខេប)

---

## 1. ហេតុអ្វីបានជាត្រូវមាន Custom Scope?

ក្រៅពី Singleton និង Prototype (ព្រមទាំង Web Scopes ដូចជា Request, Session, Application) ពេលខ្លះអាជីវកម្មត្រូវការ Scope ផ្ទាល់ខ្លួន ដូចជា **TenantScope** (Instance មួយសម្រាប់ក្រុមហ៊ុន/Tenant នីមួយៗក្នុងប្រព័ន្ធ Multi-Tenant SAAS)។

---

## 2. ការ Implement Interface `Scope`

```java
package com.example.demo.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import java.util.Collections;
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

## 3. ការចុះឈ្មោះ Custom Scope ក្នុង Container

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

## 4. សង្ខេប

- Spring អនុញ្ញាតឱ្យយើងបង្កើត Custom Scope បានដោយគ្រាន់តែ Implement `org.springframework.beans.factory.config.Scope`។



---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ](../05-singleton-and-prototype-scopes/README.kh.md) | [📚 បញ្ជីមេរៀន Module](../README.kh.md) | [ →](../07-create-spring-bean-3-ways/README.kh.md) |
