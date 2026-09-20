# Part 14: តើ Dependency Injection (DI) ជាអ្វី? (What Is Dependency Injection?)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)

![តើ Dependency Injection ជាអ្វី?](./assets/what-do-you-mean-by-di.jpg "What do you mean by Dependency Injection")

## មាតិកា (Table of Contents)

- [1. និយមន័យនៃ Dependency Injection (DI)](#1-និយមន័យនៃ-dependency-injection-di)
- [2. ប្រភេទទាំង ៣ នៃ Dependency Injection ក្នុង Spring](#2-ប្រភេទទាំង-៣-នៃ-dependency-injection-ក្នុង-spring)
- [3. កូដគំរូនៃប្រភេទ Injection នីមួយៗ](#3-កូដគំរូនៃប្រភេទ-injection-នីមួយៗ)
- [4. អត្ថប្រយោជន៍ចម្បងនៃ Dependency Injection](#4-អត្ថប្រយោជន៍ចម្បងនៃ-dependency-injection)

---

## 1. និយមន័យនៃ Dependency Injection (DI)

**Dependency Injection (DI)** ឬ **ការបញ្ចូលភាពអាស្រ័យ** គឺជាទម្រង់ជាក់ស្តែងមួយនៃគោលការណ៍ **Inversion of Control (IoC)** នៅក្នុង Spring Framework។

- **Dependency:** សំដៅលើ Object ឬ Service ណាដែល Class មួយទៀតត្រូវការជាចាំបាច់ដើម្បីបំពេញការងារ (ឧ. `OrderService` ត្រូវការ `PaymentService`)។
- **Injection:** សំដៅលើសកម្មភាពនៃការបញ្ជូន (ប្រគល់) Instance នៃ Dependency នោះទៅឱ្យ Class ដែលត្រូវការវា ដោយមិនចាំបាច់ឱ្យ Class នោះបង្កើត (`new`) ដោយខ្លួនឯងឡើយ។

> **តួនាទីរបស់ Spring DI:** ស្វែងរក Beans ដែលបានចុះឈ្មោះក្នុង [IoC Container](../07-what-is-ioc/README.kh.md) រួច Inject ផ្គុំវាបញ្ចូលគ្នាដោយស្វ័យប្រវត្តិតាមរយៈ `@Autowired` ឬ Configuration។

---

## 2. ប្រភេទទាំង ៣ នៃ Dependency Injection ក្នុង Spring

នៅក្នុង Spring Framework ការហៅ Inject នូវ Beans ត្រូវបានបែងចែកជា ៣ វិធីសាស្ត្រ៖

1. **Constructor Injection:** បញ្ចូល Dependency តាមរយៈ Parameters នៃ Class Constructor។
2. **Setter Injection:** បញ្ចូល Dependency តាមរយៈ Setter Methods របស់ Class (`set...()`)។
3. **Field Injection:** បញ្ចូល Dependency ដោយផ្ទាល់ទៅលើ Member Field តាមរយៈ `@Autowired`។

---

## 3. កូដគំរូនៃប្រភេទ Injection នីមួយៗ

### 1. Constructor Injection (វិធីសាស្ត្រដែលត្រូវបានណែនាំបំផុត)

```java
@Service
public class OrderService {

    private final PaymentService paymentService;

    // Spring នឹង Inject paymentService តាម Constructor
    @Autowired // (ក្នុង Spring 4.3+ មិនបាច់សរសេរ @Autowired ក៏បាន បើមានតែ Constructor ១)
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
```

### 2. Setter Injection (សម្រាប់ Optional Dependencies)

```java
@Service
public class OrderService {

    private NotificationService notificationService;

    // Spring នឹងហៅ Setter method នេះដើម្បី Inject
    @Autowired
    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
}
```

### 3. Field Injection (ការ Inject លើ Variable ដោយផ្ទាល់)

```java
@Service
public class OrderService {

    // Inject ដោយផ្ទាល់លើ Field (កម្រណែនាំឱ្យប្រើក្នុងកូដ Production)
    @Autowired
    private PaymentService paymentService;
}
```

---

## 4. អត្ថប្រយោជន៍ចម្បងនៃ Dependency Injection

1. **Loose Coupling (កាត់បន្ថយការពឹងពាក់):** Class របស់អ្នកពឹងផ្អែកលើ Interfaces មិនមែនលើ Concrete Implementations ឡើយ។
2. **Effortless Unit Testing:** អាចបង្កើត Mock Objects (ដូចជា `Mockito.mock(PaymentService.class)`) ហើយ Inject ចូលក្នុង Constructor ធ្វើតេស្តបានភ្លាមៗ។
3. **Clean Code Architecture:** កូដមានរបៀបរៀបរយ ស្របតាមគោលការណ៍ **SOLID Principles** (ជាពិសេស Dependency Inversion Principle)។

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកាចម្បង (Home) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← Part 13: ការយល់ដឹងស៊ីជម្រៅអំពី Singleton Scope](../13-singleton-scope/README.kh.md) | [📚 មាតិកា Spring Framework](../README.kh.md) | [Part 15: ការប្រៀបធៀប Constructor vs Setter Injection →](../15-constructor-vs-setter-injection/README.kh.md) |
