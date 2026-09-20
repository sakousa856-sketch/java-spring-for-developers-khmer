# Part 3: លក្ខណៈពិសេសរបស់ Spring Framework (Features of Spring)

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)

![លក្ខណៈពិសេសរបស់ Spring](./assets/what-are-the-features-of-spring.jpg "What are the features of Spring")

## មាតិកា (Table of Contents)

- [1. ទិដ្ឋភាពទូទៅនៃលក្ខណៈពិសេស Spring](#1-ទិដ្ឋភាពទូទៅនៃលក្ខណៈពិសេស-spring)
- [2. ក្រុមលក្ខណៈពិសេសទាំង ៦ (The 6 Feature Groups)](#2-ក្រុមលក្ខណៈពិសេសទាំង-៦-the-6-feature-groups)
- [3. តារាងសង្ខេបលក្ខណៈពិសេស (Feature Breakdown)](#3-តារាងសង្ខេបលក្ខណៈពិសេស-feature-breakdown)

---

## 1. ទិដ្ឋភាពទូទៅនៃលក្ខណៈពិសេស Spring

**Spring Framework** ផ្តល់នូវដំណោះស្រាយយ៉ាងពេញលេញសម្រាប់ Enterprise Application Development។ ដើម្បីងាយស្រួលយល់ លក្ខណៈពិសេសទាំងនោះត្រូវបានចាត់ថ្នាក់ជា ៦ ក្រុមធំៗ ចាប់ពី Core IoC រហូតដល់ Web Reactive និង Messaging។

---

## 2. ក្រុមលក្ខណៈពិសេសទាំង ៦ (The 6 Feature Groups)

### 1. Core Technologies (បច្ចេកវិទ្យាស្នូល)
ជាបេះដូងរបស់ Spring Framework ដែលរៀបចំរាល់ដំណើរការទាំងអស់៖
- **Dependency Injection (DI) & IoC Container:** ការគ្រប់គ្រង Object Lifecycle និងការផ្គុំ Components ចូលគ្នា។
- **AOP (Aspect-Oriented Programming):** ការបំបែក Cross-Cutting Concerns (Logging, Security, Transactions) ចេញពី Business Logic។
- **Events & Resources:** ប្រព័ន្ធ Publish-Subscribe សម្រាប់ Application Events និង Resource Loader។
- **I18n (Internationalization):** ការបកប្រែពហុភាសាសម្រាប់ Messages។
- **Validation, Data Binding & Type Conversion:** ការផ្ទៀងផ្ទាត់ទិន្នន័យពី Form/JSON មកកាន់ Java Object។
- **SpEL (Spring Expression Language):** ភាសា Query និង Manipulate Object Graphs ក្នុង Runtime។

### 2. Testing (ការធ្វើតេស្ត)
- **Mock Objects:** ឧបករណ៍ Mock HTTP Requests, Responses, និង Components។
- **TestContext Framework:** ការគ្រប់គ្រង Spring IoC Container កំឡុងពេល Run Unit & Integration Tests។
- **Spring MVC Test:** ការធ្វើតេស្ត Controllers ដោយមិនបាច់បើក Web Server ពិតប្រាកដ។
- **WebTestClient:** សម្រាប់តេស្ត Non-blocking Reactive WebFlux Endpoints។

### 3. Data Access & Persistence (ការគ្រប់គ្រងទិន្នន័យ)
- **Declarative Transactions:** ការគ្រប់គ្រង Transaction ស្វ័យប្រវត្តិតាមរយៈ `@Transactional`។
- **DAO Support:** ការបំប្លែង Exception របស់ Database មកជា Spring `DataAccessException` ឯកសណ្ឋាន។
- **JDBC & ORM Integration:** ដំណើរការយ៉ាងរលូនជាមួយ Hibernate, JPA, MyBatis, និង JDO។
- **Object-XML Mapping (OXM):** ការ Marshall/Unmarshal ទិន្នន័យ XML។

### 4. Web Technologies (បច្ចេកវិទ្យាគេហទំព័រ និង APIs)
- **Spring MVC:** ស្ថាបត្យកម្ម Model-View-Controller ឈរលើ Servlet API សម្រាប់ Traditional Web Apps & REST APIs។
- **Spring WebFlux:** Reactive, Non-blocking Web Framework សម្រាប់ High-Concurrency Streaming Applications។

### 5. Integration (ការតភ្ជាប់ប្រព័ន្ធខាងក្រៅ)
- **JMS & AMQP:** ការផ្ញើសារតាម Message Queues (RabbitMQ, ActiveMQ, Kafka)។
- **Email Support:** ការផ្ញើអ៊ីមែលតាម JavaMailSender។
- **Task Execution & Scheduling:** ការដំណើរការ Background Jobs តាម `@Scheduled` និង `@Async`។
- **Cache Abstraction:** ការតភ្ជាប់ Cache ដូចជា Redis, Ehcache, Hazelcast។
- **JMX & JCA:** ការគ្រប់គ្រង និង Monitor សុខភាពប្រព័ន្ធ។

### 6. Languages (ការគាំទ្រភាសា)
- ក្រៅពី Java, Spring គាំទ្រយ៉ាងពេញទំហឹងនូវ **Kotlin** (ជាមួយ Coroutines និង Null-safety), **Groovy**, និង Dynamic JVM Languages។

---

## 3. តារាងសង្ខេបលក្ខណៈពិសេស (Feature Breakdown)

| ក្រុម (Group) | បច្ចេកវិទ្យាសំខាន់ៗ | តួនាទីជាក់ស្តែង |
| :--- | :--- | :--- |
| **Core** | IoC, DI, AOP, SpEL | គ្រប់គ្រង Beans និង decoupling កូដ |
| **Data Access** | JDBC, JPA, Transactions | ភ្ជាប់ Database និងធានាសុចរិតភាពទិន្នន័យ |
| **Web** | Spring MVC, WebFlux | បង្កើត REST APIs និង Web Endpoints |
| **Testing** | Mockito, SpringBootTest | ធានាគុណភាពកូដមុនពេលឡើង Production |
| **Integration** | Redis, RabbitMQ, Kafka, Tasks | ធ្វើការជាមួយ Event-driven architectures |

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកាចម្បង (Home) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← Part 2: គុណសម្បត្តិរបស់ Spring Framework](../02-advantages-of-spring/README.kh.md) | [📚 មាតិកា Spring Framework](../README.kh.md) | [Part 4: ស្ថាបត្យកម្ម និង Modules របស់ Spring →](../04-modules-of-spring/README.kh.md) |
