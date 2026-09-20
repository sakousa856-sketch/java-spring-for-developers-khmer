# Lesson 5: Mastering @Around Advice

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)  
> 🧭 **Navigation:** [📚 Module Index](../README.md) | [← Previous Lesson](../04-after-advice/README.md) | [Next Lesson →](../06-after-throwing-advice/README.md)

---

## Table of Contents
1. [Why @Around is the Most Powerful Advice](#why-around)
2. [ProceedingJoinPoint and the proceed() Method](#proceedingjoinpoint)
3. [Building a Method Execution Profiler with Custom Annotations](#profiler)
4. [Intercepting and Altering Return Values](#return-alteration)

---

## Building a Method Execution Time Profiler

### 1. Define Custom Annotation:
```java
package com.example.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {}
```

### 2. Implement @Around Aspect:
```java
package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    private static final Logger log = LoggerFactory.getLogger(ExecutionTimeAspect.class);

    @Around("@annotation(com.example.annotation.TrackTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long elapsed = System.currentTimeMillis() - start;
        log.info("Method [{}] executed in {} ms", joinPoint.getSignature().toShortString(), elapsed);

        return result;
    }
}
```

---

## 🧭 Lesson Navigation

| Previous Lesson | Module Index | Next Lesson |
| :--- | :---: | :--- |
| [← Working with @After (Finally) Advice](../04-after-advice/README.md) | [📚 Module Index](../README.md) | [Using @AfterThrowing Advice →](../06-after-throwing-advice/README.md) |
