# មេរៀនទី ៦: ការប្រើប្រាស់ @AfterThrowing Advice (After Throwing Advice in Spring Boot)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../05-around-advice/README.md) | [មេរៀនបន្ទាប់ →](../07-after-returning-advice/README.md)

---

## មាតិកា (Table of Contents)
1. [សេចក្តីផ្តើមអំពី @AfterThrowing](#សេចក្តីផ្តើម)
2. [ការចាប់ Exception តាមរយៈ Attribute throwing](#attribute-throwing)
3. [ករណីប្រើប្រាស់: Alerting & Notification on System Faults](#alerting)

---

## ឧទាហរណ៍ជាក់ស្តែង @AfterThrowing Alert

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
        // បញ្ជូន Alert ទៅកាន់ Slack ឬ Telegram webhook...
    }
}
```

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការប្រើប្រាស់ @Around Advice ដ៏មានឥទ្ធិពលបំផុត (Around Advice in Spring Boot)](../05-around-advice/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការប្រើប្រាស់ @AfterReturning Advice (After Returning Advice) →](../07-after-returning-advice/README.md) |
