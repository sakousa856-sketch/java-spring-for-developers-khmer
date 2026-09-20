# មេរៀនទី ៥: ការប្រើប្រាស់ @Around Advice ដ៏មានឥទ្ធិពលបំផុត (Around Advice in Spring Boot)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../04-after-advice/README.md) | [មេរៀនបន្ទាប់ →](../06-after-throwing-advice/README.md)

---

## មាតិកា (Table of Contents)
1. [ហេតុអ្វីបានជា @Around ជា Advice ខ្លាំងជាងគេ?](#ហេតុអ្វី)
2. [ProceedingJoinPoint និង method proceed()](#proceedingjoinpoint)
3. [ការបង្កើត Custom Annotation សម្រាប់ Measure Execution Time](#measure-time)
4. [ការ Catch និង Modify Return Values](#modify-return)

---

## ឧទាហរណ៍វាស់ស្ទង់ពេលវេលាដំណើរការ (Execution Time Profiler)

### 1. បង្កើត Custom Annotation:
```java
package com.example.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {}
```

### 2. អនុវត្ត @Around Aspect:
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

        // ដំណើរការ Target Method ជាក់ស្តែង
        Object result = joinPoint.proceed();

        long elapsed = System.currentTimeMillis() - start;
        log.info("Method [{}] executed in {} ms", joinPoint.getSignature().toShortString(), elapsed);

        return result;
    }
}
```

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការប្រើប្រាស់ @After (Finally) Advice (After Advice in Spring Boot)](../04-after-advice/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការប្រើប្រាស់ @AfterThrowing Advice (After Throwing Advice in Spring Boot) →](../06-after-throwing-advice/README.md) |
