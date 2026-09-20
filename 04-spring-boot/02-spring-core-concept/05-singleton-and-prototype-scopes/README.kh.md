# មេរៀនទី ៥: 05-singleton-and-prototype-scopes

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)  
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.kh.md) | [← មេរៀនមុន](../04-spring-bean-lifecycle/README.kh.md) | [មេរៀនបន្ទាប់ →](../06-custom-bean-scope/README.kh.md)

## មាតិកា (Table of Contents)

- [1. ស្វែងយល់ពី Bean Scopes ក្នុង Spring](#1-ស្វែងយល់ពី-bean-scopes-ក្នុង-spring)
- [2. ការប្រៀបធៀប Singleton vs Prototype](#2-ការប្រៀបធៀប-singleton-vs-prototype)
- [3. បញ្ហាប្រឈម៖ Inject Prototype ចូលក្នុង Singleton Bean](#3-បញ្ហាប្រឈម-inject-prototype-ចូលក្នុង-singleton-bean)
- [4. សង្ខេប](#4-សង្ខេប)

---

## 1. ស្វែងយល់ពី Bean Scopes ក្នុង Spring

Scope កំណត់ពីចំនួន Object Instances ដែលត្រូវបង្កើត និងអាយុកាលរស់នៅរបស់ Bean នៅក្នុង Spring IoC Container។

---

## 2. ការប្រៀបធៀប Singleton vs Prototype

| លក្ខណៈពិសេស | Singleton Scope (Default) | Prototype Scope |
| :--- | :--- | :--- |
| **ចំនួន Instance** | បង្កើតតែ **១ គត់** ក្នុង Container ទាំងមូល | បង្កើត **ថ្មីមួយជានិច្ច** រាល់ពេលមានការស្នើសុំ |
| **ការគ្រប់គ្រង Destruction** | Spring គ្រប់គ្រងរហូតដល់ Shutdown | Spring បង្កើតរួចប្រគល់ឱ្យ Client (មិនគ្រប់គ្រង `@PreDestroy` ទេ) |
| **Statefulness** | Stateless (គ្មានរក្សាទុក User State) | Stateful (ផ្ទុកទិន្នន័យដាច់ដោយឡែក) |

```java
// 1. Singleton (Default)
@Service
public class PaymentService {}

// 2. Prototype
@Component
@Scope("prototype") // ឬ @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShoppingCart {}
```

---

## 3. បញ្ហាប្រឈម៖ Inject Prototype ចូលក្នុង Singleton Bean

នៅពេលអ្នក Inject Prototype Bean ចូលទៅក្នុង Singleton Service នោះ Prototype នឹងត្រូវបាន Inject តែម្តងគត់នៅពេល Startup ដែលធ្វើឱ្យវាប្រែក្លាយជា Singleton ដោយមិនដឹងខ្លួន!
👉 **ដំណោះស្រាយ:** ប្រើ **`@Lookup` Method** ឬ **`ObjectProvider<T>`** ដើម្បីទាញយក Instance ថ្មីរាល់ពេលហៅ!

---

## 4. សង្ខេប

- Singleton គឺជា Default Scope ក្នុង Spring (សន្សំសំចៃ Memory និងលឿន)។
- ប្រើ Prototype នៅពេល Object នីមួយៗត្រូវផ្ទុក State ផ្សេងៗគ្នា។



---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← វដ្តជីវិតរបស់ Spring Bean (Spring Bean Lifecycle)](../04-spring-bean-lifecycle/README.kh.md) | [📚 បញ្ជីមេរៀន Module](../README.kh.md) | [ →](../06-custom-bean-scope/README.kh.md) |
