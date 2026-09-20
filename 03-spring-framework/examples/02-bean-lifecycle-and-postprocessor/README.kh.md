# គម្រោងកូដគំរូ Spring Bean Lifecycle & BeanPostProcessor (ខេមរភាសា) 🇰🇭

គម្រោងនេះបង្ហាញពីដំណើរការតាមដានរាល់ជំហាននៃវដ្តជីវិតរបស់ Spring Bean ផ្ទាល់នៅលើ Console Terminal៖
1. ការបង្កើត Object (`Constructor`)
2. ការបញ្ចូល Dependencies (Dependency Injection)
3. Aware Interfaces (`BeanNameAware`)
4. `BeanPostProcessor.postProcessBeforeInitialization`
5. `@PostConstruct`
6. `InitializingBean.afterPropertiesSet`
7. `BeanPostProcessor.postProcessAfterInitialization`
8. ដំណាក់កាលត្រៀមខ្លួនរួចរាល់សម្រាប់ការងារ (In Service: `executeQuery`)
9. `@PreDestroy`
10. `DisposableBean.destroy`

## របៀបដំណើរការ (How to Run)
```bash
# Compile និង Run តាម Terminal ឬ Import ចូល IntelliJ IDEA / Eclipse
mvn compile exec:java -Dexec.mainClass="com.example.lifecycle.MainLifecycleApp"
```
