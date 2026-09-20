# មេរៀនទី ៧: ការប្រើប្រាស់ @AfterReturning Advice (After Returning Advice)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)  
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.kh.md) | [← មេរៀនមុន](../06-after-throwing-advice/README.kh.md) | [មេរៀនបន្ទាប់ →](../08-aop-vs-oop/README.kh.md)

---

## មាតិកា (Table of Contents)
1. [សេចក្តីផ្តើមអំពី @AfterReturning](#សេចក្តីផ្តើម)
2. [ការទាញយក Return Value តាមរយៈ Attribute returning](#attribute-returning)
3. [ករណីប្រើប្រាស់: Audit Logging ពេលប្រតិបត្តិការជោគជ័យ](#audit-logging)

---

## ឧទាហរណ៍ជាក់ស្តែង @AfterReturning Audit

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

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការប្រើប្រាស់ @AfterThrowing Advice (After Throwing Advice in Spring Boot)](../06-after-throwing-advice/README.kh.md) | [📚 បញ្ជីមេរៀន Module](../README.kh.md) | [ការប្រៀបធៀប AOP និង OOP (Aspect-Oriented vs Object-Oriented Programming) →](../08-aop-vs-oop/README.kh.md) |
