# មេរៀនទី ៧: វិធីទាំង ៤ ក្នុងការ Run កម្មវិធី Spring Boot

> 🌐 **ភាសា / Language:** 🇰🇭 **[ភាសាខ្មែរ (Khmer)](README.kh.md)** | 🇬🇧 [English](README.md)  
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.kh.md) | [← មេរៀនមុន](../06-intellij-idea-setup/README.kh.md) | [មេរៀនបន្ទាប់ →](../../02-spring-core-concept/01-inversion-of-control/README.kh.md)

> 📂 **កូដគំរូជាក់ស្តែង (Runnable Example Project):**  
> 👉 **គម្រោងពេញលេញ:** [Bookstore REST API (គម្រោងពេញលេញដែលអាច Run បាន)](../../examples/01-rest-api-crud)  
> 📄 **File កូដជាក់ស្តែង:** [`BookstoreApplication.java`](../../examples/01-rest-api-crud/src/main/java/com/example/bookstore/BookstoreApplication.java) | [`pom.xml`](../../examples/01-rest-api-crud/pom.xml)


## មាតិកា (Table of Contents)

- [1. សេចក្តីផ្តើម](#1-សេចក្តីផ្តើម)
- [2. វិធីទី ១៖ Run តាមរយៈ IDE (IntelliJ / STS / Eclipse)](#2-វិធីទី-១-run-តាមរយៈ-ide)
- [3. វិធីទី ២៖ Run តាមរយៈ Maven Wrapper (`./mvnw spring-boot:run`)](#3-វិធីទី-២-run-តាមរយៈ-maven-wrapper)
- [4. វិធីទី ៣៖ Build និង Run ជា Executable JAR (`java -jar`)](#4-វិធីទី-៣-build-និង-run-ជា-executable-jar)
- [5. វិធីទី ៤៖ Run ក្នុង Docker Container](#5-វិធីទី-៤-run-ក្នុង-docker-container)
- [6. សង្ខេប](#6-សង្ខេប)

---

## 1. សេចក្តីផ្តើម

Spring Boot ផ្តល់នូវភាពបត់បែនខ្ពស់ក្នុងការដំណើរការកម្មវិធី ចាប់តាំងពីម៉ាស៊ីន Local របស់ Developer រហូតដល់ Production Cloud Server។

---

## 2. វិធីទី ១៖ Run តាមរយៈ IDE

ចុចប៊ូតុងត្រីកោណពណ៌បៃតង (Play Icon) នៅក្បែរ `main()` Method ក្នុង Class `@SpringBootApplication`៖
```java
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

---

## 3. វិធីទី ២៖ Run តាមរយៈ Maven Wrapper (`./mvnw spring-boot:run`)

មិនបាច់ Install Maven លើ Terminal ក៏បាន គ្រាន់តែប្រើ Wrapper Script ដែល Spring Boot បង្កើតឱ្យស្រាប់៖
```bash
# លើ macOS / Linux:
./mvnw spring-boot:run

# លើ Windows:
mvnw.cmd spring-boot:run
```

---

## 4. វិធីទី ៣៖ Build និង Run ជា Executable JAR (`java -jar`)

នេះជាវិធីស្តង់ដារសម្រាប់ឡើង **Production / CI/CD Pipeline**៖

```bash
# ជំហានទី ១: Package កម្មវិធីជា JAR File
./mvnw clean package -DskipTests

# ជំហានទី ២: Run JAR File គ្រប់ទីកន្លែងដែលមាន Java Runtime
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

យើងក៏អាចបញ្ជូន Parameter បន្ថែមដូចជា Server Port និង Profile បានភ្លាមៗ៖
```bash
java -jar target/demo-app.jar --server.port=9090 --spring.profiles.active=prod
```

---

## 5. វិធីទី ៤៖ Run ក្នុង Docker Container

```dockerfile
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

```bash
docker build -t my-spring-app .
docker run -p 8080:8080 my-spring-app
```

---

## 6. សង្ខេប

- ប្រើ **IDE** ពេលកំពុងសរសេរកូដប្រចាំថ្ងៃ។
- ប្រើ **Maven Wrapper (`./mvnw`)** ពេលតេស្តលើ Terminal។
- ប្រើ **Executable JAR (`java -jar`)** ពេល Deploy លើ Production Cloud Server។

---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការបង្កើតគម្រោងជាមួយ IntelliJ IDEA (Community & Ultimate)](../06-intellij-idea-setup/README.kh.md) | [📚 បញ្ជីមេរៀន Module](../README.kh.md) | [ការយល់ដឹងអំពី Inversion of Control (IoC) →](../../02-spring-core-concept/01-inversion-of-control/README.kh.md) |
