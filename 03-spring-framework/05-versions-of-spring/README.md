# Part 5: កំណែទម្រង់ និងប្រវត្តិនៃ Spring Versions (Versions of Spring)
![កំណែទម្រង់នៃ Spring Framework](./assets/overview-of-versions-of-spring.jpg "Overview of versions of Spring Framework")

## មាតិកា (Table of Contents)

- [1. ប្រវត្តិនៃការវិវត្តន៍របស់ Spring Framework](#1-ប្រវត្តិនៃការវិវត្តន៍របស់-spring-framework)
- [2. បណ្ដាជំនាន់ធំៗពី Spring 1.0 ដល់ Spring 6.0](#2-បណ្ដាជំនាន់ធំៗពី-spring-10-ដល់-spring-60)
- [3. តារាងវិវត្តន៍ជំនាន់ (Version Milestones Table)](#3-តារាងវិវត្តន៍ជំនាន់-version-milestones-table)
- [4. ចំណុចសំខាន់ក្នុង Spring 6.0+ (The Modern Era)](#4-ចំណុចសំខាន់ក្នុង-spring-60-the-modern-era)

---

## 1. ប្រវត្តិនៃការវិវត្តន៍របស់ Spring Framework

**Spring Framework** ត្រូវបានបង្កើតឡើងដំបូងដោយលោក [Rod Johnson](https://en.wikipedia.org/wiki/Rod_Johnson_(programmer)) ក្នុងឆ្នាំ ២០០៣។ ឆ្លងកាត់រយៈពេលជាង ២ ទសវត្សរ៍ Spring បានផ្លាស់ប្តូរមុខមាត់របស់ពិភព Enterprise Java ទាំងស្រុង ដោយបន្តវិវត្តន៍តាមសម័យកាល បច្ចេកវិទ្យា Cloud, Microservices, និង Reactive Architecture។

---

## 2. បណ្ដាជំនាន់ធំៗពី Spring 1.0 ដល់ Spring 6.0

- **Spring 0.9 (២០០៣):** កំណែដំបូងដែលទាញចេញពីកូដគំរូក្នុងសៀវភៅរបស់ Rod Johnson។
- **Spring 1.0 (២៤ មីនា ២០០៤):** កំណែទម្រង់ជាផ្លូវការដំបូងគេបង្អស់ (1.0 GA) ដែលផ្អែកលើការកំណត់តាមរយៈ XML Configuration។
- **Spring 2.0 (តុលា ២០០៦):** ណែនាំ XML Namespaces ថ្មីៗ និងការគាំទ្រ AspectJ។
- **Spring 2.5 (វិច្ឆិកា ២០០៧):** នាំមកនូវមុខងារបដិវត្តន៍ដ៏អស្ចារ្យគឺ **Annotations** (`@Component`, `@Autowired`, `@Service`, `@Repository`) ដែលបានកាត់បន្ថយការពឹងផ្អែកលើ XML យ៉ាងច្រើនលើសលប់។
- **Spring 3.0 (ធ្នូ ២០០៩):** ណែនាំ **Spring Expression Language (SpEL)**, ការកំណត់តាម JavaConfig (`@Configuration`, `@Bean`), Environment Profiles, និងការគាំទ្រ RESTful Architecture ពេញលេញ។
- **Spring 4.0 (ធ្នូ ២០១៣):** កំណែដំបូងដែលគាំទ្រពេញលេញនូវ **Java 8** (Lambdas, Optional), WebSocket module, និងការត្រួសត្រាយផ្លូវឱ្យកើតមាន **Spring Boot**។
- **Spring 5.0 (២០១៧):** នាំមកនូវ **Spring WebFlux** (Reactive & Non-blocking web stack), ការគាំទ្រភាសា **Kotlin** យ៉ាងរលូន, និងតម្រូវការអប្បបរមាត្រឹម Java 8+ / Java 9។
- **Spring 6.0 (២២ វិច្ឆិកា ២០២២):** ផ្លាស់ប្តូរទៅកាន់យុគសម័យ Cloud Native ដោយកំណត់យក **Java 17+** ជាកម្រិតអប្បបរមា, ផ្លាស់ប្តូរ Package ពី `javax.*` ទៅ **`jakarta.*` (Jakarta EE 9+)**, និងគាំទ្រ **Ahead-of-Time (AOT)** Compilation ជាមួយ **GraalVM Native Images** ធ្វើឱ្យកម្មវិធី Start ត្រឹមរង្វង់ Milliseconds!

---

## 3. តារាងវិវត្តន៍ជំនាន់ (Version Milestones Table)

| ជំនាន់ (Version) | កាលបរិច្ឆេទចេញផ្សាយ | តម្រូវការ Java អប្បបរមា | មុខងារលេចធ្លោបំផុត |
| :--- | :--- | :--- | :--- |
| **Spring 1.0** | ២០០៤ | Java 1.3 / 1.4 | Core IoC Container, XML Config |
| **Spring 2.5** | ២០០៧ | Java 5 | Annotation-driven configuration (`@Autowired`) |
| **Spring 3.0** | ២០០៩ | Java 5 / 6 | SpEL, Java-based Configuration, REST APIs |
| **Spring 4.0** | ២០១៣ | Java 8 | Java 8 Lambda support, WebSocket, Conditional beans |
| **Spring 5.0** | ២០១៧ | Java 8+ | Reactive WebFlux, Kotlin support, HTTP/2 |
| **Spring 6.0** | ២០២២ | **Java 17+** | Jakarta EE 9+, GraalVM Native Image, AOT |

---

## 4. ចំណុចសំខាន់ក្នុង Spring 6.0+ (The Modern Era)

ប្រសិនបើអ្នកកំពុងរៀន ឬអភិវឌ្ឍកម្មវិធីថ្មីជាមួយ **Spring Boot 3.x** ឬ **Spring Framework 6.x**៖
1. **Java Baseline:** អ្នកត្រូវតែប្រើប្រាស់ Java 17 ឬ Java 21 LTS ឡើងទៅ។
2. **Jakarta Namespace:** រាល់ Import statements ពាក់ព័ន្ធនឹង Servlet, Persistence, Validation ត្រូវបានប្តូរពី `javax.persistence.*` ទៅជា `jakarta.persistence.*` ទាំងអស់។

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកាចម្បង (Home) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← Part 4: ស្ថាបត្យកម្ម និង Modules របស់ Spring](../04-modules-of-spring/README.md) | [📚 មាតិកា Spring Framework](../README.md) | [Part 6: តើ Inversion of Control (IoC) ជាអ្វី? →](../06-what-is-ioc/README.md) |
