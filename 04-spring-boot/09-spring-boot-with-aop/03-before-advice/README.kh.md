# មេរៀនទី ៣: ការប្រើប្រាស់ @Before Advice (Before Advice in Spring Boot)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)  
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.kh.md) | [← មេរៀនមុន](../02-aop-advices-overview/README.kh.md) | [មេរៀនបន្ទាប់ →](../04-after-advice/README.kh.md)

---

## មាតិកា (Table of Contents)
1. [សេចក្តីផ្តើមអំពី @Before Advice](#សេចក្តីផ្តើម)
2. [Pointcut Expression Syntax](#pointcut-expression)
3. [ការចាប់យក Method Parameters ជាមួយ JoinPoint](#joinpoint-parameters)
4. [ករណីប្រើប្រាស់ជាក់ស្តែង: Security Check & Logging](#ករណីប្រើប្រាស់)

---

## ឧទាហរណ៍ជាក់ស្តែង @Before Logging

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

    // Pointcut លើគ្រប់ methods ទាំងអស់ក្នុង package service
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

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ទិដ្ឋភាពទូទៅនៃប្រភេទ AOP Advices ទាំង ៥ (Overview of AOP Advices)](../02-aop-advices-overview/README.kh.md) | [📚 បញ្ជីមេរៀន Module](../README.kh.md) | [ការប្រើប្រាស់ @After (Finally) Advice (After Advice in Spring Boot) →](../04-after-advice/README.kh.md) |
