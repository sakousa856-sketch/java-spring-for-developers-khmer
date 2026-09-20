# Part 22: Spring AOP & Proxy Mechanics in Core Spring

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)
> 
> 📖 **Official Spring Documentation:** [Aspect Oriented Programming with Spring](https://docs.spring.io/spring-framework/reference/core/aop.html) | [AOP Proxies](https://docs.spring.io/spring-framework/reference/core/aop/proxying.html)

![Spring AOP & Proxy Mechanics](./assets/spring-aop-proxy-mechanics.svg "Spring AOP & Dynamic Proxy Mechanics")

## Table of Contents

- [1. Cross-Cutting Concerns & AOP Architecture](#1-cross-cutting-concerns--aop-architecture)
- [2. The 5 Core Concepts of AOP](#2-the-5-core-concepts-of-aop)
- [3. Proxies Under the Hood: JDK Dynamic Proxy vs CGLIB](#3-proxies-under-the-hood-jdk-dynamic-proxy-vs-cglib)
- [4. Enabling & Authoring Aspects with @EnableAspectJAutoProxy](#4-enabling--authoring-aspects-with-enableaspectjautoproxy)
- [5. The Self-Invocation Trap (this.method())](#5-the-self-invocation-trap-thismethod)
- [6. Practical Code Challenge](#6-practical-code-challenge)
- [🔗 Official Spring Documentation](#-official-spring-documentation)

---

## 1. Cross-Cutting Concerns & AOP Architecture

In enterprise applications, secondary requirements such as **Logging**, **Security validation**, **Transactions**, and **Metrics collection** cut across multiple architectural layers.

Scattering these concerns manually violates DRY and degrades modularity. **Aspect-Oriented Programming (AOP)** encapsulates cross-cutting concerns into modular units known as **Aspects**, non-invasively wrapping business services using runtime proxies.

---

## 2. The 5 Core Concepts of AOP

1. **Aspect:** A module containing cross-cutting logic (annotated with `@Aspect`).
2. **JoinPoint:** A candidate execution point in the application (in Spring AOP, strictly **method executions** on managed beans).
3. **Pointcut:** A predicate matching specific JoinPoints (e.g., `execution(* com.example.service.*.*(..))`).
4. **Advice:** Action taken at a join point: `@Before`, `@After`, `@Around`, `@AfterReturning`, `@AfterThrowing`.
5. **Weaving:** The linking of aspects with target objects to produce an augmented **Proxy**.

---

## 3. Proxies Under the Hood: JDK Dynamic Proxy vs CGLIB

Spring AOP does not perform compile-time bytecode weaving (like full AspectJ). Instead, it creates **Runtime Proxies**:

| Attribute | JDK Dynamic Proxy | CGLIB Proxy |
| :--- | :--- | :--- |
| **Underlying Mechanism** | Built into standard JDK (`java.lang.reflect.Proxy`) | Third-party bytecode manipulation |
| **Target Requirement** | Class **must implement an interface** | No interface required (generates subclass) |
| **Limitations** | Only proxies interface methods | **Cannot proxy `final` classes or `final` methods** |
| **Spring Boot 3.x Default**| Fallback | **Primary Default** |

---

## 4. Enabling & Authoring Aspects with @EnableAspectJAutoProxy

```java
@Configuration
@ComponentScan("com.example")
@EnableAspectJAutoProxy
public class AopConfiguration {}

@Aspect
@Component
public class LatencyMonitorAspect {

    @Around("execution(* com.example.service.*.*(..))")
    public Object profile(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object outcome = joinPoint.proceed();

        long duration = System.currentTimeMillis() - start;
        System.out.printf("[LATENCY] %s took %d ms%n", 
                joinPoint.getSignature().toShortString(), duration);

        return outcome;
    }
}
```

---

## 5. The Self-Invocation Trap (this.method())

A classic senior engineering pitfall:
> **Why do `@Transactional` or custom aspects fail to fire when a method is called from another method within the exact same class?**

```java
@Service
public class OrderService {

    public void checkout() {
        // Self-invocation bypasses the Spring Proxy!
        // Calling this.validate() invokes the target object directly.
        this.validate(); 
    }

    @AuditLog
    public void validate() {
        System.out.println("Validating order parameters...");
    }
}
```

**Resolution:**
- Refactor the helper method into a separate dedicated component (Best Practice).
- Or inject the self-reference via `@Lazy`.

---

## 6. Practical Code Challenge

**Challenge:** Create a custom annotation `@Monitored`. Write an aspect containing an `@Around` advice that logs the method execution time exclusively for methods bearing `@Monitored`.

<details>
<summary>🔍 Click to view solution</summary>

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Monitored {}

@Aspect
@Component
public class MetricAspect {

    @Around("@annotation(com.example.Monitored)")
    public Object monitor(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        try {
            return pjp.proceed();
        } finally {
            long elapsed = (System.nanoTime() - start) / 1_000_000;
            System.out.printf("[PERF] %s finished in %d ms%n", pjp.getSignature().getName(), elapsed);
        }
    }
}
```
</details>

---

## 🔗 Official Spring Documentation

- [Aspect Oriented Programming with Spring](https://docs.spring.io/spring-framework/reference/core/aop.html)
- [AOP Proxies in Spring Core](https://docs.spring.io/spring-framework/reference/core/aop/proxying.html)
- [Declaring an Aspect in Spring](https://docs.spring.io/spring-framework/reference/core/aop/ataspectj.html)

---

## 🧭 Lesson Navigation

| Previous | Main Index | Next |
| :--- | :---: | :--- |
| [← Part 21: Spring Application Events](../21-spring-application-events/README.md) | [📚 Spring Framework Index](../README.md) | [Part 23: Circular Dependencies & Resolution →](../23-circular-dependencies-resolution/README.md) |
