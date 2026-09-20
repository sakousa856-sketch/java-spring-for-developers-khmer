# Lesson 3: Using @Before Advice in Spring Boot

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../02-aop-advices-overview/README.md) | [Next Lesson →](../04-after-advice/README.md)

---

## Table of Contents
1. [Introduction to @Before Advice](#introduction)
2. [Pointcut Expression Syntax](#pointcut-expression)
3. [Inspecting Method Signatures via JoinPoint](#joinpoint-inspection)
4. [Real-World Use Cases: Pre-Execution Auditing & Security](#use-cases)

---

## Practical @Before Logging Aspect

```java
package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
public class LoggingBeforeAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingBeforeAspect.class);

    @Pointcut("execution(* com.example.service.*.*(..))")
    public void serviceMethods() {}

    @Before("serviceMethods()")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("Entering method: [{}] with arguments: {}", methodName, Arrays.toString(args));
    }
}
```

---

## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Overview of AOP Advices](../02-aop-advices-overview/README.md) | [📚 Module Index](../README.md) | [Working with @After (Finally) Advice →](../04-after-advice/README.md) |
