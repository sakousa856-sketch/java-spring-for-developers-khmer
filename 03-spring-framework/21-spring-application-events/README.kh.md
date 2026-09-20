# Part 21: ស្ថាបត្យកម្ម Event-Driven ក្នុង Spring (Spring Application Events: @EventListener)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)
> 
> 📖 **ឯកសារយោងផ្លូវការ Spring Docs:** [Standard and Custom Events](https://docs.spring.io/spring-framework/reference/core/beans/context-introduction.html#context-functionality-events) | [Annotation-based Event Listeners](https://docs.spring.io/spring-framework/reference/core/beans/context-introduction.html#context-functionality-events-annotation)

![Spring Application Events Architecture](./assets/spring-application-events.svg "Spring Application Events: Publisher, Listeners & Async")

## មាតិកា (Table of Contents)

- [1. គោលការណ៍ Observer Pattern និងអត្ថប្រយោជន៍នៃ Decoupling](#1-គោលការណ៍-observer-pattern-និងអត្ថប្រយោជន៍នៃ-decoupling)
- [2. ការបង្កើត Custom Event (POJO Event)](#2-ការបង្កើត-custom-event-pojo-event)
- [3. ការបោះ Event ដោយ ApplicationEventPublisher](#3-ការបោះ-event-ដោយ-applicationeventpublisher)
- [4. ការស្តាប់ Event ដោយ @EventListener](#4-ការស្តាប់-event-ដោយ-eventlistener)
- [5. ការដំណើរការ Asynchronous Events ដោយស្រោប @Async](#5-ការដំណើរការ-asynchronous-events-ដោយស្រោប-async)
- [6. Transaction-Bound Events (@TransactionalEventListener)](#6-transaction-bound-events-transactionaleventlistener)
- [7. លំហាត់អនុវត្តកូដ (Code Challenge)](#7-លំហាត់អនុវត្តកូដ-code-challenge)
- [🔗 ឯកសារយោងផ្លូវការ Spring Docs](#-ឯកសារយោងផ្លូវការ-spring-docs)

---

## 1. គោលការណ៍ Observer Pattern និងអត្ថប្រយោជន៍នៃ Decoupling

នៅក្នុងស្ថាបត្យកម្ម Enterprise សេវាកម្មមួយអាចមានកិច្ចការបន្ទាប់បន្សំជាច្រើន។ ឧទាហរណ៍ ពេលអ្នកប្រើប្រាស់ចុះឈ្មោះ (`registerUser`):
1. បង្កើតគណនីក្នុង Database
2. ផ្ញើ Email ស្វាគមន៍
3. ផ្ញើ SMS កូដ OTP
4. បង្កើតប្រវត្តិ Analytics

ប្រសិនបើ `UserService` ត្រូវ Inject ទាំង `EmailService`, `SmsService`, និង `AnalyticsService` នោះកូដនឹងក្លាយជា **Tight Coupling** ស្មុគស្មាញ និងយឺត។

ដំណោះស្រាយរបស់ Spring គឺ **Spring Application Events (Observer Pattern)**៖
- `UserService` គ្រាន់តែបោះ `UserRegisteredEvent` រួចចប់ភារកិច្ច។
- សេវាកម្មដទៃទៀតគ្រាន់តែដាក់ `@EventListener` ដើម្បីចាំទទួល Event នោះមកធ្វើការងាររៀងៗខ្លួន។

---

## 2. ការបង្កើត Custom Event (POJO Event)

តាំងពី Spring 4.2 មក Event មិនចាំបាច់ Extend ពី `ApplicationEvent` ឡើយ — វាគឺជា Java POJO ឬ Record សាមញ្ញ៖

```java
// ប្រើ Java Record សម្រាប់ Immutability ខ្ពស់បំផុត
public record UserRegisteredEvent(String userId, String email, String fullName) {
}
```

---

## 3. ការបោះ Event ដោយ ApplicationEventPublisher

Spring ផ្តល់នូវ `ApplicationEventPublisher` មកស្រាប់សម្រាប់ធ្វើជា Event Bus៖

```java
@Service
public class UserService {

    private final ApplicationEventPublisher eventPublisher;

    public UserService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void register(String userId, String email, String name) {
        System.out.println("1. រក្សាទុក User ទៅក្នុង Database: " + userId);

        // បោះ Event ចេញទៅកាន់ Container
        eventPublisher.publishEvent(new UserRegisteredEvent(userId, email, name));
        
        System.out.println("2. ចុះឈ្មោះជោគជ័យ និងបានបោះ Event រួចរាល់!");
    }
}
```

---

## 4. ការស្តាប់ Event ដោយ @EventListener

សេវាកម្មដទៃគ្រាន់តែបង្កើត Method ដែលមាន Parameter ជាប្រភេទ Event នោះ រួចដាក់ `@EventListener`៖

```java
@Component
public class NotificationListener {

    @EventListener
    public void sendWelcomeEmail(UserRegisteredEvent event) {
        System.out.println("[EMAIL] ផ្ញើអ៊ីមែលស្វាគមន៍ទៅកាន់: " + event.email());
    }

    @EventListener
    public void trackAnalytics(UserRegisteredEvent event) {
        System.out.println("[ANALYTICS] កត់ត្រា Profile ថ្មីសម្រាប់ User: " + event.userId());
    }
}
```

---

## 5. ការដំណើរការ Asynchronous Events ដោយស្រោប @Async

តាមលំនាំដើម `@EventListener` ដំណើរការលើ Thread តែមួយជាមួយអ្នកបោះ Event (Synchronous)។ ប្រសិនបើការងារនោះស៊ីពេលយូរ (ដូចជាការផ្ញើ Email) យើងអាចដំណើរការវាលើ Background Thread ដោយស្រោប `@Async`៖

```java
@Configuration
@EnableAsync
public class AsyncConfig {
}

@Component
public class AsyncEmailService {

    @Async
    @EventListener
    public void onUserRegistered(UserRegisteredEvent event) {
        System.out.println("[ASYNC] ដំណើរការផ្ញើអ៊ីមែលលើ Thread ដាច់ដោយឡែក: " + Thread.currentThread().getName());
    }
}
```

---

## 6. Transaction-Bound Events (@TransactionalEventListener)

នៅក្នុងប្រព័ន្ធធនាគារ ឬទូទាត់ប្រាក់ យើងចង់ឱ្យ Event ដំណើរការ **លុះត្រាតែ Database Transaction ត្រូវបាន COMMIT ជោគជ័យជាមុនសិន** (ដើម្បីការពារកុំឱ្យផ្ញើ SMS ឬ Email ប្រសិនបើ Database មានបញ្ហា Rollback)៖

```java
@Component
public class TransactionalAuditListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onOrderCreated(OrderCreatedEvent event) {
        System.out.println("ដំណើរការតែពេល Database Transaction បាន Commit ជោគជ័យប៉ុណ្ណោះ!");
    }
}
```

---

## 7. លំហាត់អនុវត្តកូដ (Code Challenge)

**លំហាត់:** ចូរបង្កើត Event ឈ្មោះ `OrderPlacedEvent` ផ្ទុក `orderId` និង `amount`។ បង្កើត `InventoryListener` ដែលមាន `@EventListener` កាត់បន្ថយស្តុកទំនិញ និង `ReceiptListener` ដែលមាន `@EventListener` បោះពុម្ពវិក្កយបត្រ។

<details>
<summary>🔍 ចុចទីនេះដើម្បីមើលដំណោះស្រាយគំរូ</summary>

```java
public record OrderPlacedEvent(String orderId, double amount) {}

@Component
public class InventoryListener {
    @EventListener
    public void reduceStock(OrderPlacedEvent event) {
        System.out.println("កាត់បន្ថយស្តុកសម្រាប់ Order: " + event.orderId());
    }
}

@Component
public class ReceiptListener {
    @EventListener
    public void printReceipt(OrderPlacedEvent event) {
        System.out.printf("វិក្កយបត្រ Order #%s: $%.2f%n", event.orderId(), event.amount());
    }
}
```
</details>

---

## 🔗 ឯកសារយោងផ្លូវការ Spring Docs

- [Standard and Custom Events](https://docs.spring.io/spring-framework/reference/core/beans/context-introduction.html#context-functionality-events)
- [Annotation-based Event Listeners](https://docs.spring.io/spring-framework/reference/core/beans/context-introduction.html#context-functionality-events-annotation)
- [Asynchronous Event Listeners](https://docs.spring.io/spring-framework/reference/core/beans/context-introduction.html#context-functionality-events-async)

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកាចម្បង (Home) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← Part 20: ភាសាកន្សោម SpEL](../20-spring-expression-language-spel/README.kh.md) | [📚 មាតិកា Spring Framework](../README.kh.md) | [Part 22: Spring AOP & Proxies →](../22-spring-aop-and-proxies/README.kh.md) |
