# មេរៀនទី ៤: ការគ្រប់គ្រង Starter Dependencies (Dependency Management)
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../03-auto-configuration/README.md) | [មេរៀនបន្ទាប់ →](../05-application-properties/README.md)

## មាតិកា (Table of Contents)

- [1. របៀបបង្កើត Project ជាមួយ Spring Initializr](#1-របៀបបង្កើត-project-ជាមួយ-spring-initializr)
- [2. រចនាសម្ព័ន្ធ Folder ស្តង់ដាររបស់ Spring Boot](#2-រចនាសម្ព័ន្ធ-folder-ស្តង់ដាររបស់-spring-boot)
- [3. តើអ្វីទៅជា Starter Dependencies?](#3-តើអ្វីទៅជា-starter-dependencies)
- [4. យន្តការគ្រប់គ្រងកំណែតាម Bill of Materials (BOM)](#4-យន្តការគ្រប់គ្រងកំណែតាម-bill-of-materials-bom)
- [5. តារាង Starters ពេញនិយមបំផុត](#5-តារាង-starters-ពេញនិយមបំផុត)

---

## 1. របៀបបង្កើត Project ជាមួយ Spring Initializr

វិធីសាស្ត្រផ្លូវការ និងលឿនបំផុតក្នុងការបង្កើត Spring Boot Project គឺតាមរយៈគេហទំព័រ **[start.spring.io](https://start.spring.io/)** (Spring Initializr)៖

1. **Project:** ជ្រើសរើស **Maven** ឬ **Gradle** (Maven ត្រូវបានប្រើប្រាស់ច្រើនក្នុង Enterprise)
2. **Language:** **Java**
3. **Spring Boot Version:** ជ្រើសរើសជំនាន់ LTS ចុងក្រោយ (ឧ. `3.2.x` ឬ `3.3.x`)
4. **Project Metadata:**
   - `Group`: ឈ្មោះ Domain របស់ស្ថាប័ន (ឧ. `com.example` ឬ `kh.poscommerce`)
   - `Artifact`: ឈ្មោះ App (ឧ. `order-service`)
   - `Packaging`: **Jar** (Stand-alone executable)
   - `Java Version`: **17** ឬ **21** (កម្រិតអប្បបរមាសម្រាប់ Spring Boot 3+)
5. **Dependencies:** ជ្រើសរើស `Spring Web`, `Spring Data JPA`, `Lombok`, `PostgreSQL Driver`
6. ចុច **GENERATE** ដើម្បីទាញយក `.zip` file រួចបើកក្នុង **IntelliJ IDEA**, **VS Code**, ឬ **STS**។

---

## 2. រចនាសម្ព័ន្ធ Folder ស្តង់ដាររបស់ Spring Boot

```
my-spring-boot-app/
├── pom.xml                         # ឯកសារគ្រប់គ្រង Dependencies (Maven)
├── src/
│   ├── main/
│   │   ├── java/                   # កូដ Java ទាំងអស់
│   │   │   └── com/example/demo/
│   │   │       └── DemoApplication.java  # Main Class (មាន @SpringBootApplication)
│   │   └── resources/              # ឯកសារ Configuration & Static Assets
│   │       ├── application.properties    # ឬ application.yml
│   │       ├── static/                   # ផ្ទុក CSS, JS, Images សម្រាប់ Web
│   │       └── templates/                # ផ្ទុក Thymeleaf / HTML templates
│   └── test/
│       └── java/                   # កូដសម្រាប់សរសេរ Unit & Integration Tests
```

---

## 3. តើអ្វីទៅជា Starter Dependencies?

**Spring Boot Starters** គឺជាកញ្ចប់ Aggregated Dependencies សម្រេចស្រាប់។ ជំនួសឱ្យការ Copy/Paste បណ្ណាល័យ Jar ដាច់ដោយឡែករាប់សិបចូលក្នុង `pom.xml` អ្នកគ្រាន់តែហៅ Starter មួយគត់៖

```xml
<!-- ឧទាហរណ៍៖ ហៅតែមួយ Starter ទទួលបាន Web Stack ទាំងមូល -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>

</dependency>
```

នៅពេលអ្នកដាក់ `spring-boot-starter-web` វានឹងទាញយកដោយស្វ័យប្រវត្តិនូវ៖
- `spring-web` និង `spring-webmvc`
- `tomcat-embed-core` (Embedded Apache Tomcat Server)
- `jackson-databind` (សម្រាប់បំប្លែង JSON)
- `spring-boot-starter-validation` (សម្រាប់ Validate Form/JSON)

---

## 4. យន្តការគ្រប់គ្រងកំណែតាម Bill of Materials (BOM)

តើអ្នកធ្លាប់កត់សម្គាល់ទេថា ហេតុអ្វីបានជា Dependencies របស់ Spring Boot មិនមានដាក់លេខ Tag `<version>`?

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
    <!-- គ្មាន <version>3.2.0</version> ឡើយ! -->

</dependency>
```

នេះគឺដោយសារ Spring Boot ប្រើប្រាស់ **`spring-boot-starter-parent`** ឬ **BOM (Bill of Materials)** នៅក្នុង `pom.xml`៖
- Parent POM បានកំណត់កំណែដែលត្រូវគ្នា ១០០% រវាង Hibernate, Tomcat, Jackson, PostgreSQL Driver រួចជាស្រេច។
- ជួយការពារបញ្ហា **"Jar Version Conflict"** (Jar Hell) ដែលធ្លាប់ធ្វើឱ្យ Developer ឈឺក្បាលកាលពីអតីតកាល។

---

## 5. តារាង Starters ពេញនិយមបំផុត

| Starter Name | មុខងារចម្បង |
| :--- | :--- |
| **`spring-boot-starter-web`** | បង្កើត RESTful APIs, Spring MVC, Embedded Tomcat |
| **`spring-boot-starter-data-jpa`** | ភ្ជាប់ Database តាម Hibernate, JPA, និង HikariCP Pool |
| **`spring-boot-starter-security`** | ការពារ Authentication & Authorization (JWT, OAuth2) |
| **`spring-boot-starter-validation`** | ផ្ទៀងផ្ទាត់ Input Data តាម Jakarta Bean Validation |
| **`spring-boot-starter-actuator`** | Production monitoring, Metrics, Health check endpoints |
| **`spring-boot-starter-test`** | សំណុំ Tool ធ្វើតេស្ត៖ JUnit 5, Mockito, AssertJ, MockMvc |


---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← យន្តការកំណត់រចនាសម្ព័ន្ធស្វ័យប្រវត្តិ (Auto-Configuration Deep Dive)](../03-auto-configuration/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការកំណត់រចនាសម្ព័ន្ធជាមួយ Application Properties →](../05-application-properties/README.md) |
