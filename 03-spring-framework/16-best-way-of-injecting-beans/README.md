# Part 16: វិធីសាស្រ្តល្អបំផុតក្នុងការ Inject Beans & ហេតុផល (Best Way of Injecting Beans)
![វិធីសាស្រ្តល្អបំផុតក្នុងការ Inject Beans](./assets/which-is-the-best-way-of-injecting-beans-and-why.jpg "Which Is the Best Way of Injecting Beans and Why")

## មាតិកា (Table of Contents)

- [1. ចម្លើយសង្ខេប (The Short Answer)](#1-ចម្លើយសង្ខេប-the-short-answer)
- [2. មូលហេតុធំៗទាំង ៤ ដែលត្រូវជ្រើសរើស Constructor Injection](#2-មូលហេតុធំៗទាំង-៤-ដែលត្រូវជ្រើសរើស-constructor-injection)
- [3. ហេតុអ្វីបានជា Field Injection ត្រូវបានចាត់ទុកជា Code Smell?](#3-ហេតុអ្វីបានជា-field-injection-ត្រូវបានចាត់ទុកជា-code-smell)
- [4. សរសេរកូដឱ្យកាន់តែខ្លី និងស្អាតជាមួយ Lombok](#4-សរសេរកូដឱ្យកាន់តែខ្លី-និងស្អាតជាមួយ-lombok)
- [5. សេចក្តីសន្និដ្ឋាននៃវគ្គសិក្សា (Course Conclusion)](#5-សេចក្តីសន្និដ្ឋាននៃវគ្គសិក្សា-course-conclusion)

---

## 1. ចម្លើយសង្ខេប (The Short Answer)

> **វិធីសាស្ត្រល្អបំផុតក្នុងការ Inject Beans នៅក្នុង Spring Framework គឺ៖**
> ### 🏆 **Constructor Injection**

នេះគឺជាអនុសាសន៍ផ្លូវការពីក្រុមការងារបង្កើត Spring Framework (Pivotal / VMware Tanzu) និងត្រូវបានទទួលស្គាល់ជា Best Practice ជាសកលក្នុងពិភពវិស្វកម្មសូហ្វវែរ Java។

---

## 2. មូលហេតុធំៗទាំង ៤ ដែលត្រូវជ្រើសរើស Constructor Injection

1. **Immutability (ភាពមិនអាចប្រែប្រួល - Thread Safety):**
   - អនុញ្ញាតឱ្យយើងប្រកាស Member Variables ជា `final`។ នៅពេល Object ត្រូវបានបង្កើតរួច គ្មានកូដណាអាចផ្លាស់ប្តូរ Reference របស់វាបានឡើយ ដែលជួយការពារបញ្ហា Race Condition ក្នុង Multithreading។

2. **Null Safety (ធានាសុវត្ថិភាព គ្មាន NullPointerException):**
   - Java Compiler បង្ខំឱ្យយើងត្រូវតែបញ្ជូន Dependency គ្រប់គ្រាន់ពេលហៅ Constructor។ កម្មវិធីមិនអាចបង្កើត Object ដែលមាន Dependency មិនទាន់គ្រប់គ្រងបានឡើយ ជួយលុបបំបាត់កំហុស `NullPointerException` (NPE) បានស្ទើរតែ ១០០%។

3. **Pure POJO Unit Testing (ងាយស្រួលធ្វើ Test បំផុត):**
   - ក្នុង Unit Test អ្នកមិនចាំបាច់ប្រើ Spring Test Runner (`@SpringBootTest`) ឬ Reflection ស្មុគស្មាញឡើយ។ អ្នកគ្រាន់តែហៅ `new OrderService(mockRepo, mockPayment)` ដោយប្រើ Java សុទ្ធសាធ ធ្វើឱ្យ Test ដំណើរការលឿនដូចផ្លេកបន្ទោរ (Milliseconds)។

4. **Code Smell Detection (ដឹងមុនពេល Class មានការទទួលខុសត្រូវច្រើនហួសហេតុ):**
   - ប្រសិនបើ Class មួយមាន Constructor Parameters រហូតដល់ ៧-៨ Dependencies នោះអ្នកនឹងដឹងភ្លាមថា Class នេះកំពុងបំពានគោលការណ៍ **Single Responsibility Principle (SRP)** ហើយត្រូវតែ Refactor បំបែកជា Classes តូចៗ។

---

## 3. ហេតុអ្វីបានជា Field Injection ត្រូវបានចាត់ទុកជា Code Smell?

កាលពីមុន Developer និយមប្រើ Field Injection ព្រោះវាងាយសរសេរ៖
```java
// ❌ មិនត្រូវបានណែនាំ (Bad Practice)
@Service
public class OrderService {
    @Autowired
    private PaymentService paymentService;
}
```

**បញ្ហាធ្ងន់ធ្ងរនៃ Field Injection៖**
- **លាក់បាំងការពឹងពាក់ (Hidden Dependencies):** មើលពីក្រៅមិនដឹងថា Class នេះត្រូវការអ្វីខ្លះទេ។
- **ពិបាកធ្វើ Unit Test:** ដោយសារ Field ជា `private` អ្នកមិនអាច Inject Mock Object ចូលបានឡើយ លុះត្រាតែប្រើ Reflection ឬបើក Spring Context ទាំងមូល។
- **មិនអាចប្រើ `final` បានឡើយ:** ធ្វើឱ្យបាត់បង់អត្ថប្រយោជន៍ Immutability។

---

## 4. សរសេរកូដឱ្យកាន់តែខ្លី និងស្អាតជាមួយ Lombok

ដើម្បីកុំឱ្យពិបាកសរសេរ Constructor វែងៗ អ្នកអាចប្រើ **Project Lombok** ជាមួយ `@RequiredArgsConstructor`៖

```java
@Service
@RequiredArgsConstructor // បង្កើត Constructor សម្រាប់តែ final fields ដោយស្វ័យប្រវត្តិ
public class OrderService {

    private final PaymentService paymentService;
    private final NotificationService notificationService;

    // មិនបាច់សរសេរ Constructor ឬ @Autowired ដោយដៃឡើយ!
}
```

---

## 5. សេចក្តីសន្និដ្ឋាននៃដំណាក់កាលទី ៤ និងការបោះជំហានបន្ទាប់ (Phase 4 Conclusion & Next Steps)

សូមអបអរសាទរ! អ្នកបានបញ្ចប់ដំណាក់កាលទី ៤ នៃមូលដ្ឋានគ្រឹះ **Spring Framework IoC & Dependency Injection**៖
- យល់ដឹងច្បាស់ពីទស្សនវិជ្ជានៃ Inversion of Control (IoC)
- ចេះគ្រប់គ្រង Spring Beans, Bean Scopes, និង Container Mechanics
- ស្ទាត់ជំនាញលើ Constructor Injection ជាមួយ Immutability និង Null Safety

នៅក្នុង **ដំណាក់កាលទី ៥ (Advanced Bean Mechanics & Lifecycle)** បន្ទាប់ទៀត យើងនឹងឈានទៅកាន់ប្រធានបទកម្រិតខ្ពស់ដែលវិស្វករជាន់ខ្ពស់ប្រើប្រាស់ជារៀងរាល់ថ្ងៃ៖
- **Part 17:** ការដោះស្រាយបញ្ហា Bean Ambiguity ដោយប្រើ `@Primary`, `@Qualifier` និង Custom Qualifiers!

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកាចម្បង (Home) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← Part 15: ការប្រៀបធៀប Constructor vs Setter Injection](../15-constructor-vs-setter-injection/README.md) | [📚 មាតិកា Spring Framework](../README.md) | [Part 17: ការដោះស្រាយភាពស្រពិចស្រពិលនៃ Bean →](../17-bean-ambiguity-primary-qualifier/README.md) |
