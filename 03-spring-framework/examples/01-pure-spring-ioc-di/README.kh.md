# គម្រោងកូដគំរូ Pure Spring 6 IoC & DI (ខេមរភាសា) 🇰🇭

គម្រោងដែលអាចដំណើរការបាននេះបង្ហាញពីរបៀបដែល Spring Framework 6 ដំណើរការជាមូលដ្ឋានសុទ្ធដោយមិនបាច់ពឹងផ្អែកលើ Spring Boot៖
- **ការចាប់ផ្ដើម IoC Container:** `AnnotationConfigApplicationContext`
- **Metadata Configuration:** `@Configuration`, `@ComponentScan`, `@PropertySource`
- **Dependency Injection:** Constructor Injection ជាមួយ Immutability
- **ការដោះស្រាយ Bean ស្រពិចស្រពិល (Ambiguity Resolution):** `@Primary` vs `@Qualifier`
- **ការបញ្ចូល Property:** `@Value("${...}")` ពីឯកសារ `application.properties`

## របៀបដំណើរការ (How to Run)
```bash
# Compile និង Run តាម Terminal ឬ Import ចូល IntelliJ IDEA / Eclipse
mvn compile exec:java -Dexec.mainClass="com.example.core.MainApp"
```
