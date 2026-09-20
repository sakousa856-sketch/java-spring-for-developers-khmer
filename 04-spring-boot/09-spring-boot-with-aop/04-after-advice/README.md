# Lesson 4: Working with @After (Finally) Advice

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../03-before-advice/README.md) | [Next Lesson →](../05-around-advice/README.md)

---

## Table of Contents
1. [Introduction to @After Advice](#introduction)
2. [Difference Between @After and @AfterReturning](#differences)
3. [Implementing Resource Cleanups](#cleanup-implementation)

---

## Practical @After Resource Cleanup

```java
package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResourceCleanUpAspect {

    private static final Logger log = LoggerFactory.getLogger(ResourceCleanUpAspect.class);

    @After("execution(* com.example.service.FileProcessorService.processFile(..))")
    public void cleanupTempFiles(JoinPoint joinPoint) {
        log.info("Method [{}] has completed (success or error). Executing resource cleanup.",
                joinPoint.getSignature().getName());
    }
}
```

---

## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Using @Before Advice in Spring Boot](../03-before-advice/README.md) | [📚 Module Index](../README.md) | [Mastering @Around Advice →](../05-around-advice/README.md) |
