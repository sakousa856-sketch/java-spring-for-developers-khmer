# Part 6: តើ Inversion of Control (IoC) ជាអ្វី? (What Is IoC?)
![តើ IoC ជាអ្វី?](./assets/what-do-you-mean-by-ioc.jpg "What do you mean by IoC (Inversion of Control)")

## មាតិកា (Table of Contents)

- [1. និយមន័យនៃ Inversion of Control (IoC)](#1-និយមន័យនៃ-inversion-of-control-ioc)
- [2. គោលការណ៍ហូលីវូដ (The Hollywood Principle)](#2-គោលការណ៍ហូលីវូដ-the-hollywood-principle)
- [3. ការប្រៀបធៀប៖ Traditional Control vs Inverted Control](#3-ការប្រៀបធៀប-traditional-control-vs-inverted-control)
- [4. តួនាទីរបស់ IoC Container ក្នុង Spring](#4-តួនាទីរបស់-ioc-container-ក្នុង-spring)
- [5. វិធីទាំង ៣ ក្នុងការផ្តល់ Metadata ទៅកាន់ IoC Container](#5-វិធីទាំង-៣-ក្នុងការផ្តល់-metadata-ទៅកាន់-ioc-container)

---

## 1. និយមន័យនៃ Inversion of Control (IoC)

**Inversion of Control (IoC)** ឬ **ការត្រឡប់ការគ្រប់គ្រង** គឺជាគោលការណ៍ស្ថាបត្យកម្មសូហ្វវែរ (Design Principle) មួយដែលផ្លាស់ប្តូរការគ្រប់គ្រងលើការបង្កើត (Instantiation) និងការតភ្ជាប់ (Wiring) រវាង Objects ពីដៃរបស់អ្នកសរសេរកូដ ទៅឱ្យ **Framework (IoC Container)** ជាអ្នកគ្រប់គ្រងជំនួសវិញ។

នៅក្នុង Spring Framework មុខងារស្នូល **IoC Container** ទទួលខុសត្រូវលើ៖
1. ការបង្កើត Object (Create Instances)
2. ការកំណត់តម្លៃ និងតភ្ជាប់ Dependencies (Inject Dependencies)
3. ការគ្រប់គ្រងវដ្តជីវិតរបស់ Objects ទាំងមូល (Manage Lifecycle) តាំងពីពេលចាប់ផ្តើម រហូតដល់បំផ្លាញចោល។

---

## 2. គោលការណ៍ហូលីវូដ (The Hollywood Principle)

IoC ត្រូវបានគេស្គាល់យ៉ាងច្បាស់តាមរយៈទស្សនវិជ្ជាហៅថា **The Hollywood Principle**:
> *"Don't call us, we'll call you." (កុំទូរស័ព្ទមករកយើង ចាំយើងទូរស័ព្ទទៅអ្នកវិញ)*

- **ក្នុងកូដបុរាណ:** Class របស់អ្នកដើរតួជាមេកើយ — ពេលណាត្រូវការ Helper Class មួយ វានឹងហៅ `new Helper()` ដោយខ្លួនឯង។
- **ក្នុង Spring IoC:** Class របស់អ្នកដើរតួជាអ្នករង់ចាំ — អ្នកគ្រាន់តែប្រកាសថាត្រូវការ `Helper` ហើយទុកឱ្យ Spring IoC Container ជាអ្នកយក Instance មកប្រគល់ឱ្យ (Inject) ក្នុងពេលសមស្រប។

---

## 3. ការប្រៀបធៀប៖ Traditional Control vs Inverted Control

```
[វិធីបុរាណ - Traditional Control]
OrderService ───> ហៅ new PaymentService() ដោយផ្ទាល់ (Tight Coupling)

[វិធី Spring IoC - Inverted Control]
┌────────────────────────┐
│  Spring IoC Container  │
│  - បង្កើត PaymentService│
│  - បង្កើត OrderService  │
│  - Inject បញ្ចូលគ្នា   │
└───────────┬────────────┘
            │ ផ្តល់ឱ្យ (Injected)
            ▼
       OrderService (Loose Coupling)
```

---

## 4. តួនាទីរបស់ IoC Container ក្នុង Spring

Spring IoC Container ដំណើរការដូចជា **រោងចក្រផលិត និងផ្គុំគ្រឿងបន្លាស់ (Object Factory & Assembler)**៖
1. **អាន Configuration Metadata:** អានការកំណត់ដែលយើងបានប្រាប់ (XML, Java Config, ឬ Annotations)។
2. **បង្កើត POJO Classes:** បង្កើត Instance របស់ Classes នីមួយៗឱ្យក្លាយជា **Spring Beans**។
3. **ផ្គុំគ្រឿង (Wiring):** រកមើលថា Bean ណាត្រូវការ Bean ណា រួចហើយ Inject ភ្ជាប់គ្នាដោយស្វ័យប្រវត្តិ។

---

## 5. វិធីទាំង ៣ ក្នុងការផ្តល់ Metadata ទៅកាន់ IoC Container

ដើម្បីឱ្យ IoC Container ដឹងពីរបៀបបង្កើត និងគ្រប់គ្រង Beans យើងអាចផ្តល់ការណែនាំតាម ៣ វិធី៖
- **1. XML-Based Configuration:** សរសេរការកំណត់ក្នុងឯកសារ XML (ឧ. `applicationContext.xml`)។
- **2. Annotation-Based Configuration:** ប្រើ Annotations លើ Class ដូចជា `@Component`, `@Service`, `@Repository`។
- **3. Java-Based Configuration:** ប្រើប្រាស់ Java Class ផ្ទាល់ដែលមាន `@Configuration` និង `@Bean`។

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកាចម្បង (Home) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← Part 5: កំណែទម្រង់ និងប្រវត្តិនៃ Spring Versions](../05-versions-of-spring/README.md) | [📚 មាតិកា Spring Framework](../README.md) | [Part 7: ប្រភេទនៃ IoC Containers →](../07-types-of-ioc-container/README.md) |
