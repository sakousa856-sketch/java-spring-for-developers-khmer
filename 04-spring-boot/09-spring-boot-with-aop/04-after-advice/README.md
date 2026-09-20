# មេរៀនទី ៤: ការប្រើប្រាស់ @After (Finally) Advice (After Advice in Spring Boot)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../03-before-advice/README.md) | [មេរៀនបន្ទាប់ →](../05-around-advice/README.md)

---

## មាតិកា (Table of Contents)
1. [សេចក្តីផ្តើមអំពី @After (Finally) Advice](#សេចក្តីផ្តើម)
2. [ភាពខុសគ្នារវាង @After និង @AfterReturning](#ភាពខុសគ្នា)
3. [ការអនុវត្តជាក់ស្តែងសម្រាប់ Clean Up Resources](#ការអនុវត្ត)

---

## ឧទាហរណ៍ជាក់ស្តែង @After Clean Up

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
        // Clean up thread-local or temporary file buffers
    }
}
```

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការប្រើប្រាស់ @Before Advice (Before Advice in Spring Boot)](../03-before-advice/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការប្រើប្រាស់ @Around Advice ដ៏មានឥទ្ធិពលបំផុត (Around Advice in Spring Boot) →](../05-around-advice/README.md) |
