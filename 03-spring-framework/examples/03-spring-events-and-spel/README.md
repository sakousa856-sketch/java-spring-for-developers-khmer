# គម្រោងកូដគំរូ Spring Application Events & SpEL (ខេមរភាសា) 🇰🇭

គម្រោងដែលអាចដំណើរការបាននេះបង្ហាញអំពី៖
1. **Spring Application Events:** ការបញ្ជូន Event បែប Domain POJO (`OrderPlacedEvent`) ដោយប្រើប្រាស់ `ApplicationEventPublisher` និងការចាប់ស្ដាប់យ៉ាងស្អាតតាមរយៈ `@EventListener`។
2. **Spring Expression Language (SpEL):** ការគណនាលេខបែប Dynamic, ការកែប្រែអក្សរ (String manipulation), និងការហៅ Static Methods របស់ Java Math តាមរយៈកន្សោម `#{...}`។

## របៀបដំណើរការ (How to Run)
```bash
# Compile និង Run តាម Terminal ឬ Import ចូល IntelliJ IDEA / Eclipse
mvn compile exec:java -Dexec.mainClass="com.example.eventandspel.MainEventAndSpELApp"
```
