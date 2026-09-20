# Part 2: គុណសម្បត្តិរបស់ Spring Framework (Advantages of Spring)
![គុណសម្បត្តិរបស់ Spring](./assets/advantages-of-spring.jpg "Advantages of Spring")

## មាតិកា (Table of Contents)

- [1. គុណសម្បត្តិសំខាន់ៗទាំង ៧ របស់ Spring Framework](#1-គុណសម្បត្តិសំខាន់ៗទាំង-៧-របស់-spring-framework)
- [2. ឧទាហរណ៍ជាក់ស្តែង៖ ការកាត់បន្ថយកូដជាមួយ JdbcTemplate](#2-ឧទាហរណ៍ជាក់ស្តែង-ការកាត់បន្ថយកូដជាមួយ-jdbctemplate)
- [3. តារាងប្រៀបធៀបគុណសម្បត្តិ (Advantages Comparison)](#3-តារាងប្រៀបធៀបគុណសម្បត្តិ-advantages-comparison)

---

## 1. គុណសម្បត្តិសំខាន់ៗទាំង ៧ របស់ Spring Framework

Spring Framework ទទួលបានការគាំទ្រយ៉ាងខ្លាំងដោយសារតែគុណសម្បត្តិដ៏លេចធ្លោដូចខាងក្រោម៖

1. **Predefined Templates (គំរូកូដសម្រេចស្រាប់ៗ):**
   - Spring ផ្តល់នូវ Helper Classes និង Templates ស្រាប់ៗសម្រាប់បច្ចេកវិទ្យា Database ដូចជា **JDBC**, **Hibernate**, និង **JPA**។
   - អ្នកអភិវឌ្ឍន៍មិនបាច់សរសេរកូដគ្រប់គ្រង Connection, Statement, Transaction ឬ Exception Handling ដដែលៗនោះឡើយ។

2. **Loose Coupling (ភាពបត់បែន និងការកាត់បន្ថយការពឹងពាក់គ្នា):**
   - តាមរយៈយន្តការ **Dependency Injection (DI)** និង **Inversion of Control (IoC)** កូដនីមួយៗមិនចាំបាច់បង្កើត Class ដែលខ្លួនត្រូវការដោយផ្ទាល់នោះទេ ធ្វើឱ្យ Component នីមួយៗឯករាជ្យ និងងាយស្រួលផ្លាស់ប្តូរ។

3. **Easy to Test (ងាយស្រួលក្នុងការធ្វើតេស្ត):**
   - ដោយសារ Component នីមួយៗជា POJO និងពឹងផ្អែកលើ Interfaces យើងអាច Inject **Mock Objects** ចូលទៅក្នុង Unit Test បានយ៉ាងងាយស្រួល ដោយមិនចាំបាច់បើក Server ឬ Database ពិតប្រាកដ។

4. **Lightweight (ស្រាល និងមិនស៊ីធនធាន):**
   - កំណែទម្រង់មូលដ្ឋានរបស់ Spring Core មានទំហំតូច និងដំណើរការលើ Plain-Old-Java-Objects (POJOs) ធម្មតា មិនទាមទារ Application Server ធំៗដូចជា WebLogic ឬ WebSphere ឡើយ។

5. **Fast Development (ការអភិវឌ្ឍរហ័សទាន់ចិត្ត):**
   - ការកម្ចាត់កូដ Boilerplate និងការផ្តល់ជូននូវ Auto-Configuration ជួយសន្សំសំចៃពេលវេលារបស់ Developer បានរាប់រយម៉ោង។

6. **Powerful Abstraction (ការបិទបាំងភាពស្មុគស្មាញដ៏រឹងមាំ):**
   - Spring ផ្តល់នូវស្រទាប់ Abstraction ដ៏ល្អសម្រាប់បច្ចេកវិទ្យា JavaEE ដូចជា **JMS** (Messaging), **JDBC/JPA** (Data), និង **JTA** (Distributed Transactions)។

7. **Declarative Support (ការកំណត់តាមរយៈ Annotation):**
   - គាំទ្រការគ្រប់គ្រងមុខងារស្មុគស្មាញតាមរយៈ Annotation សាមញ្ញៗដូចជា `@Transactional`, `@Cacheable`, `@Validated` ដោយមិនចាំបាច់សរសេរកូដច្រើនជួរឡើយ។

---

## 2. ឧទាហរណ៍ជាក់ស្តែង៖ ការកាត់បន្ថយកូដជាមួយ JdbcTemplate

### វិធីបែបបុរាណ (Raw JDBC)
អ្នកត្រូវសរសេរកូដរហូតដល់ ២០-៣០ ជួរសម្រាប់តែ Query មួយ៖
- បើក `Connection`
- បង្កើត `PreparedStatement`
- ចាប់ `SQLException`
- បើក `ResultSet`
- បិទ `ResultSet`, `PreparedStatement`, និង `Connection` ក្នុងប្លុក `finally`

### វិធីបែប Spring (`JdbcTemplate`)
Spring ទទួលខុសត្រូវរាល់ការងារទាំងអស់ខាងលើ អ្នកគ្រាន់តែប្រាប់ Spring ថាតើចង់ Run Query អ្វីប៉ុណ្ណោះ៖

```java
public List<User> getAllUsers() {
    String sql = "SELECT id, name, email FROM users";
    return jdbcTemplate.query(sql, (rs, rowNum) -> 
        new User(rs.getLong("id"), rs.getString("name"), rs.getString("email"))
    );
}
```

---

## 3. តារាងប្រៀបធៀបគុណសម្បត្តិ (Advantages Comparison)

| គុណសម្បត្តិ (Advantage) | ដំណោះស្រាយប្រពៃណី | អត្ថប្រយោជន៍ក្នុង Spring |
| :--- | :--- | :--- |
| **Data Access** | សរសេរ JDBC boilerplate ច្រើន | `JdbcTemplate` & Spring Data JPA |
| **Testing** | ពិបាក Mock ដោយសារ `new` ជាប់កូដ | Mockito + Spring TestContext |
| **Transaction** | សរសេរ `commit()` & `rollback()` ដោយដៃ | ប្រើ `@Transactional` មួយជួរចប់ |
| **Modularity** | គម្រោងធំពិបាកបំបែក | រើសយកតែ Module ណាដែលត្រូវការប្រើ |

---

## 🧭 ការរុករកមេរៀន (Lesson Navigation)

| ថយក្រោយ (Previous) | មាតិកាចម្បង (Home) | បន្ទាប់ (Next) |
| :--- | :---: | :--- |
| [← Part 1: តើ Spring Framework ជាអ្វី?](../01-what-is-spring/README.md) | [📚 មាតិកា Spring Framework](../README.md) | [Part 3: លក្ខណៈពិសេសរបស់ Spring Framework →](../03-features-of-spring/README.md) |
