# Lesson 7: Using @AfterReturning Advice

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../06-after-throwing-advice/README.md) | [Next Lesson →](../08-aop-vs-oop/README.md)

---

## Table of Contents
1. [Introduction to @AfterReturning](#introduction)
2. [Binding Return Objects via the returning Attribute](#returning-attribute)
3. [Audit Logging of Successful Operations](#audit-logging)

---

## Practical @AfterReturning Audit Aspect

```java
package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditLogAspect {

    private static final Logger log = LoggerFactory.getLogger(AuditLogAspect.class);

    @AfterReturning(
        pointcut = "execution(* com.example.service.OrderService.createOrder(..))",
        returning = "orderResult"
    )
    public void auditSuccessfulOrder(JoinPoint joinPoint, Object orderResult) {
        log.info("Audit: Order created successfully! Details: {}", orderResult);
    }
}
```

---

## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Using @AfterThrowing Advice](../06-after-throwing-advice/README.md) | [📚 Module Index](../README.md) | [AOP vs OOP (Aspect-Oriented vs Object-Oriented Programming) →](../08-aop-vs-oop/README.md) |
