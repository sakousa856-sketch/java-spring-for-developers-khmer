# មេរៀនទី ៨: ការប្រើប្រាស់ Autowiring ជាមួយ @Autowired

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)  
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.kh.md) | [← មេរៀនមុន](../07-create-spring-bean-3-ways/README.kh.md) | [មេរៀនបន្ទាប់ →](../09-dispatcherservlet/README.kh.md)

> 📂 **កូដគំរូជាក់ស្តែង (Runnable Example Project):**  
> 👉 **គម្រោងពេញលេញ:** [Bookstore REST API (Service Injection)](../../examples/01-rest-api-crud)  
> 📄 **File កូដជាក់ស្តែង:** [`BookController.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/controller/BookController.java) | [`BookService.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/service/BookService.java)


## មាតិកា (Table of Contents)

- [1. យន្តការ Autowiring ក្នុង Spring](#1-យន្តការ-autowiring-ក្នុង-spring)
- [2. បញ្ហាប្រឈមនៃ Ambiguity (ពេលមាន Bean ច្រើន)](#2-បញ្ហាប្រឈមនៃ-ambiguity)
- [3. ដំណោះស្រាយជាមួយ `@Primary` និង `@Qualifier`](#3-ដំណោះស្រាយជាមួយ-primary-និង-qualifier)
- [4. សង្ខេប](#4-សង្ខេប)

---

## 1. យន្តការ Autowiring ក្នុង Spring

`@Autowired` ប្រាប់ Spring ឱ្យស្វែងរក Bean ណាដែលត្រូវគ្នាក្នុង Container មកចាក់បញ្ចូលដោយស្វ័យប្រវត្តិ (by Type)។

---

## 2. បញ្ហាប្រឈមនៃ Ambiguity

ប្រសិនបើយើងមាន Interface `PaymentGateway` មួយ តែមាន Class អនុវត្តចំនួន ២ (`StripePayment` និង `PaypalPayment`)៖
```java
@Service
public class CheckoutService {
    // នឹងបោះ NoUniqueBeanDefinitionException ព្រោះ Spring មិនដឹងថាត្រូវរើសយកមួយណា!
    public CheckoutService(PaymentGateway paymentGateway) { ... }
}
```

---

## 3. ដំណោះស្រាយជាមួយ `@Primary` និង `@Qualifier`

### ដំណោះស្រាយទី ១៖ `@Primary` (កំណត់អាទិភាពចម្បង)
```java
@Component
@Primary // បើគេមិនបញ្ជាក់ឈ្មោះ យក Stripe ជានិច្ច
public class StripePayment implements PaymentGateway {}
```

### ដំណោះស្រាយទី ២៖ `@Qualifier` (បញ្ជាក់ឈ្មោះជាក់លាក់)
```java
@Service
public class CheckoutService {
    public CheckoutService(@Qualifier("paypalPayment") PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
}
```

---

## 4. សង្ខេប

- Spring Autowires Beans តាម Type ជាចម្បង។
- ប្រើ `@Primary` ដើម្បីផ្តល់អាទិភាព Default និងប្រើ `@Qualifier` ដើម្បីបញ្ជាក់ឈ្មោះ Bean ច្បាស់លាស់។

---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ](../07-create-spring-bean-3-ways/README.kh.md) | [📚 បញ្ជីមេរៀន Module](../README.kh.md) | [ →](../09-dispatcherservlet/README.kh.md) |
