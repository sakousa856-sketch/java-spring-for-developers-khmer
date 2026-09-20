# Part 17: Resolving Bean Ambiguity (@Primary & @Qualifier)

> 🌐 **Language / ភាសា:** 🇬🇧 **[English](README.md)** | 🇰🇭 [ភាសាខ្មែរ (Khmer)](README.kh.md)
> 
> 📖 **Official Spring Documentation:** [Fine-tuning Annotation-based Autowiring with Qualifiers](https://docs.spring.io/spring-framework/reference/core/beans/annotation-config/autowired-qualifiers.html) | [Primary Beans](https://docs.spring.io/spring-framework/reference/core/beans/annotation-config/autowired-primary.html)

![Bean Ambiguity Resolution](./assets/bean-ambiguity-resolution.svg "Bean Ambiguity Resolution: @Primary vs @Qualifier")

## Table of Contents

- [1. Bean Ambiguity & NoUniqueBeanDefinitionException](#1-bean-ambiguity--nouniquebeandefinitionexception)
- [2. Solution 1: Using @Primary for Default Fallback](#2-solution-1-using-primary-for-default-fallback)
- [3. Solution 2: Using @Qualifier for Explicit Targeting](#3-solution-2-using-qualifier-for-explicit-targeting)
- [4. Custom Qualifier Meta-Annotations](#4-custom-qualifier-meta-annotations)
- [5. Injecting All Candidate Beans as a Collection](#5-injecting-all-candidate-beans-as-a-collection)
- [6. Practical Code Challenge](#6-practical-code-challenge)
- [🔗 Official Spring Documentation](#-official-spring-documentation)

---

## 1. Bean Ambiguity & NoUniqueBeanDefinitionException

When adhering to the **Dependency Inversion Principle** and programming to interfaces, an interface often has multiple implementations registered inside the Spring container.

For example, consider the `PaymentService` interface:
```java
public interface PaymentService {
    void processPayment(double amount);
}
```
Implemented by two separate managed components:
```java
@Service
public class PaypalPaymentService implements PaymentService {
    public void processPayment(double amount) {
        System.out.println("Processing PayPal: $" + amount);
    }
}

@Service
public class StripePaymentService implements PaymentService {
    public void processPayment(double amount) {
        System.out.println("Processing Stripe: $" + amount);
    }
}
```

When an `OrderService` attempts to inject `PaymentService`:
```java
@Service
public class OrderService {
    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
```

### 💥 What Happens at Runtime?
Spring fails fast during context startup with a `NoUniqueBeanDefinitionException`:
```
No qualifying bean of type 'com.example.PaymentService' available:
expected single matching bean but found 2: paypalPaymentService, stripePaymentService
```
Spring refuses to guess which bean implementation your business logic requires.

---

## 2. Solution 1: Using @Primary for Default Fallback

If one implementation serves as the primary or standard choice throughout the application, annotate it with `@Primary`:

```java
@Service
@Primary
public class StripePaymentService implements PaymentService {
    public void processPayment(double amount) {
        System.out.println("Processing Stripe payment by default: $" + amount);
    }
}
```
Now, whenever `PaymentService` is requested without explicit qualification, `StripePaymentService` is injected automatically.

---

## 3. Solution 2: Using @Qualifier for Explicit Targeting

When a specific dependent class requires a non-default implementation, use `@Qualifier` at the injection point:

```java
@Service
public class CheckoutService {

    private final PaymentService paymentService;

    public CheckoutService(@Qualifier("paypalPaymentService") PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
```

> **💡 Precedence Rule:**
> `@Qualifier` always takes precedence over `@Primary`. If a candidate has `@Primary` but an injection site specifies `@Qualifier("otherBean")`, Spring fulfills the qualification strictly.

---

## 4. Custom Qualifier Meta-Annotations

Hardcoding string literals like `@Qualifier("paypalPaymentService")` introduces typo vulnerabilities during refactoring. Spring allows you to create custom qualifier annotations:

```java
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface PaypalGateway {
}
```

Apply it seamlessly across your bean declaration and injection target:
```java
@Service
@PaypalGateway
public class PaypalPaymentService implements PaymentService { ... }

@Service
public class OrderService {
    public OrderService(@PaypalGateway PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
```

---

## 5. Injecting All Candidate Beans as a Collection

If your design leverages the **Strategy Pattern**, you can inject all candidate beans simultaneously into a `List` or a `Map`:

```java
@Service
public class PaymentGatewayManager {

    // Map: Key = Bean Name, Value = Bean Instance
    private final Map<String, PaymentService> paymentServices;

    public PaymentGatewayManager(Map<String, PaymentService> paymentServices) {
        this.paymentServices = paymentServices;
    }

    public void process(String gatewayName, double amount) {
        PaymentService service = paymentServices.get(gatewayName + "PaymentService");
        if (service == null) {
            throw new IllegalArgumentException("Unknown gateway: " + gatewayName);
        }
        service.processPayment(amount);
    }
}
```

---

## 6. Practical Code Challenge

**Challenge:** Create a `NotificationService` interface with `void notify(String text)`. Provide two implementations: `EmailService` (marked with `@Primary`) and `SmsService` (marked with custom qualifier `@SmsProvider`). Build an `AlertManager` that explicitly requires `@SmsProvider`.

<details>
<summary>🔍 Click to view solution</summary>

```java
public interface NotificationService {
    void notify(String text);
}

@Service
@Primary
public class EmailService implements NotificationService {
    public void notify(String text) { System.out.println("Email: " + text); }
}

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface SmsProvider {}

@Service
@SmsProvider
public class SmsService implements NotificationService {
    public void notify(String text) { System.out.println("SMS: " + text); }
}

@Service
public class AlertManager {
    private final NotificationService service;

    public AlertManager(@SmsProvider NotificationService service) {
        this.service = service;
    }

    public void trigger(String alert) {
        service.notify(alert);
    }
}
```
</details>

---

## 🔗 Official Spring Documentation

- [Fine-tuning Annotation-based Autowiring with Qualifiers](https://docs.spring.io/spring-framework/reference/core/beans/annotation-config/autowired-qualifiers.html)
- [Primary Beans in Spring](https://docs.spring.io/spring-framework/reference/core/beans/annotation-config/autowired-primary.html)
- [Generics as Autowiring Qualifiers](https://docs.spring.io/spring-framework/reference/core/beans/annotation-config/autowired-generics.html)

---

## 🧭 Lesson Navigation

| Previous | Main Index | Next |
| :--- | :---: | :--- |
| [← Part 16: Best Way of Injecting Beans](../16-best-way-of-injecting-beans/README.md) | [📚 Spring Framework Index](../README.md) | [Part 18: Bean Lifecycle & BeanPostProcessor →](../18-bean-lifecycle-and-postprocessor/README.md) |
