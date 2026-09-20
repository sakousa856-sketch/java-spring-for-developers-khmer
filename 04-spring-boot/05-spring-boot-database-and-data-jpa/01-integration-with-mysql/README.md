# មេរៀនទី ១: ការតភ្ជាប់ Spring Boot ជាមួយ MySQL Database
> 🧭 **រុករក:** [📚 មាតិកា Module](../README.md) | [← មេរៀនមុន](../../04-spring-boot-with-rest-api/11-validation/README.md) | [មេរៀនបន្ទាប់ →](../02-integration-with-postgresql/README.md)

## មាតិកា (Table of Contents)

- [1. សេចក្តីផ្តើមអំពី Database Drivers ក្នុង Spring Boot](#1-សេចក្តីផ្តើមអំពី-database-drivers-ក្នុង-spring-boot)
- [2. In-Memory H2 Database សម្រាប់ការរៀន និង Unit Testing](#2-in-memory-h2-database-សម្រាប់ការរៀន-និង-unit-testing)
- [3. ការតភ្ជាប់ជាមួយ PostgreSQL](#3-ការតភ្ជាប់ជាមួយ-postgresql)
- [4. ការតភ្ជាប់ជាមួយ MySQL](#4-ការតភ្ជាប់ជាមួយ-mysql)
- [5. HikariCP Connection Pool (បេះដូងនៃ Performance)](#5-hikaricp-connection-pool-បេះដូងនៃ-performance)
- [6. ការយល់ដឹងអំពី `spring.jpa.hibernate.ddl-auto` (គ្រោះថ្នាក់ពេលឡើង Production)](#6-ការយល់ដឹងអំពី-springjpahibernateddl-auto-គ្រោះថ្នាក់ពេលឡើង-production)
- [7. សង្ខេប](#7-សង្ខេប)

---

## 1. សេចក្តីផ្តើមអំពី Database Drivers ក្នុង Spring Boot

Spring Boot ប្រើប្រាស់យន្តការ Auto-Configuration ដើម្បីរៀបចំ Datasource ដោយស្វ័យប្រវត្តិ។ អ្វីដែលអ្នកត្រូវធ្វើ គឺគ្រាន់តែ៖
1. បញ្ចូល **JDBC Driver Dependency** ក្នុង `pom.xml`។
2. កំណត់ Connection URL, Username, និង Password ក្នុង `application.yml` ឬ `application.properties`។

---

## 2. In-Memory H2 Database សម្រាប់ការរៀន និង Unit Testing

**H2** គឺជា Database ស្រាលបំផុតដែលដំណើរការក្នុង RAM នៃ JVM។ វាមិនទាមទារឱ្យអ្នក Install Server អ្វីទាំងអស់ ហើយទិន្នន័យនឹងត្រូវលុបចោលស្វ័យប្រវត្តិនៅពេល Server បិទ (Restart)។

### `pom.xml`:
```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>

</dependency>
```

### `application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1
    driver-class-name: org.h2.Driver
    username: sa
    password: 
  h2:
    console:
      enabled: true
      path: /h2-console
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: create-drop
```
*(អ្នកអាចបើក Browser ចូលទៅកាន់ `http://localhost:8080/h2-console` ដើម្បីមើល Table និង Execute SQL បានភ្លាមៗ)*។

---

## 3. ការតភ្ជាប់ជាមួយ PostgreSQL

PostgreSQL គឺជា Relational Database បែប Open-source ដ៏ពេញនិយមបំផុតសម្រាប់ Enterprise និង Microservices ទំនើប។

### `pom.xml`:
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>

</dependency>
```

### `application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/ecommerce_db
    username: postgres
    password: mysecretpassword
    driver-class-name: org.postgresql.Driver
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
```

---

## 4. ការតភ្ជាប់ជាមួយ MySQL

### `pom.xml`:
```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>

</dependency>
```

### `application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/ecommerce_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
    username: root
    password: rootpassword
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    database-platform: org.hibernate.dialect.MySQLDialect
    hibernate:
      ddl-auto: update
    show-sql: true
```

---

## 5. HikariCP Connection Pool (បេះដូងនៃ Performance)

Spring Boot ប្រើប្រាស់ **HikariCP** ជា Default Connection Pool។ ការបើក Connection ទៅកាន់ Database ជាការងារដែលស៊ី CPU និង Memory ខ្លាំង។ Connection Pool រក្សាទុក Connection ដែលបើករួចជាស្រេច ដើម្បីឱ្យ Request អាចខ្ចីប្រើបានភ្លាមៗ។

```yaml
spring:
  datasource:
    hikari:
      maximum-pool-size: 20       # ចំនួន Connection អតិបរមាក្នុងពេលតែមួយ
      minimum-idle: 5             # ចំនួន Connection ទុកទំនេររង់ចាំ
      idle-timeout: 300000        # 5 នាទី (លុបចោល Connection អសកម្ម)
      connection-timeout: 20000   # 20 វិនាទី (Timeout ប្រសិនបើគ្មាន Connection ទំនេរ)
      pool-name: SpringBootHikariCP
```

---

## 6. ការយល់ដឹងអំពី `spring.jpa.hibernate.ddl-auto` (គ្រោះថ្នាក់ពេលឡើង Production)

| តម្លៃ (Value) | អាកប្បកិរិយារបស់ Hibernate | បរិយាកាសស័ក្តិសម (Environment) |
| :--- | :--- | :--- |
| **`none`** | មិនប៉ះពាល់ Database ឡើយ (គ្មានការបង្កើត ឬកែប្រែ Table) | 🚨 **Production (ចាំបាច់)** |
| **`validate`** | ត្រួតពិនិត្យតែប៉ុណ្ណោះ ប្រសិនបើ Java Entity មិនដូច Table ក្នុង DB វានឹងគាំង Start មិនចេញ | 🛡️ **Staging / Production** |
| **`update`** | បន្ថែម Table ឬ Column ថ្មីស្វ័យប្រវត្តិតាម Entity (មិនលុប Column ចាស់ទេ) | 💻 **Local Development ប៉ុណ្ណោះ** |
| **`create`** | `DROP TABLE` ចោលទាំងអស់ រួចបង្កើតថ្មីរាល់ពេល Start App | 🧪 ការពិសោធន៍ខ្លីៗ |
| **`create-drop`** | បង្កើតពេល Start ហើយលុបចោលទាំងអស់ពេល Shutdown | 🧪 **Unit Testing (H2 DB)** |

> ⚠️ **ការព្រមានកម្រិតក្រហម:** ដាច់ខាត **កុំប្រើ `ddl-auto: update` ឬ `create` លើ Production** ឱ្យសោះ! វាអាចធ្វើឱ្យទិន្នន័យអតិថិជនរាប់លានត្រូវបានលុបបាត់បង់ (Data Loss)។ សម្រាប់ Production ត្រូវប្រើ Database Migration Tools ដូចជា **Flyway** ឬ **Liquibase**។

---

## 7. សង្ខេប

- ប្រើ **H2 Database** សម្រាប់ការរៀន និង Unit Testing ព្រោះវាមិនត្រូវការ Install Server។
- ប្រើ **PostgreSQL** ឬ **MySQL** សម្រាប់កម្មវិធីជាក់ស្តែង។
- **HikariCP** ត្រូវបានកំណត់យ៉ាងល្អឥតខ្ចោះដោយស្វ័យប្រវត្តិ តែអាចកែសម្រួល Pool Size បានតាមទំហំ Server។
- កំណត់ `ddl-auto: validate` ឬ `none` ជានិច្ចនៅលើ Production Server។


---
## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកា Module (Index) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← ការផ្ទៀងផ្ទាត់ទិន្នន័យ (Input Validation) ជាមួយ Jakarta Bean Validation](../../04-spring-boot-with-rest-api/11-validation/README.md) | [📚 បញ្ជីមេរៀន Module](../README.md) | [ការភ្ជាប់ Spring Boot ជាមួយ PostgreSQL (Integration with PostgreSQL) →](../02-integration-with-postgresql/README.md) |
