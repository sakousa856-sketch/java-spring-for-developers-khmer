# Lesson 6: Using @AfterThrowing Advice

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../05-around-advice/README.md) | [Next Lesson →](../07-after-returning-advice/README.md)

---

## Table of Contents
1. [Introduction to @AfterThrowing](#introduction)
2. [Capturing Exceptions with the throwing Attribute](#throwing-attribute)
3. [Use Case: Centralized Failure Alerting](#alerting)

---

## Practical @AfterThrowing Alerting Aspect

```java
package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GlobalExceptionLoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionLoggingAspect.class);

    @AfterThrowing(
        pointcut = "execution(* com.example.service.*.*(..))",
        throwing = "ex"
    )
    public void logAfterException(JoinPoint joinPoint, Throwable ex) {
        log.error("Exception thrown in method [{}]: Reason: {}",
                joinPoint.getSignature().getName(), ex.getMessage(), ex);
    }
}
```

---

## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Mastering @Around Advice](../05-around-advice/README.md) | [📚 Module Index](../README.md) | [Using @AfterReturning Advice →](../07-after-returning-advice/README.md) |
