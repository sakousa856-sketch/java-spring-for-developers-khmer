# គម្រោងគំរូ: Distributed Caching ជាមួយ Redis (Spring Boot 3)

[English Version](./README.md)

គម្រោងនេះបង្ហាញពីការប្រើប្រាស់ Redis ជា Distributed Cache ជាមួយ `@Cacheable`, `@CacheEvict`, TTL, និង JSON Serialization។

## របៀបដំណើរការ

```bash
# 1. បើក Redis តាម Docker
docker compose up -d

# 2. Run Spring Boot
mvn spring-boot:run
```

សាកល្បងហៅ `GET http://localhost:8080/api/v1/products/1`:
- លើកទី ១: យឺត ២ វិនាទី (Query Database)
- លើកទី ២: លឿនស្ទើរតែ 0ms (ទាញយកពី Redis Cache ផ្ទាល់)
