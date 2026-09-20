# គម្រោងគំរូ: Event-Driven Architecture ជាមួយ Apache Kafka (Spring Boot 3)

[English Version](./README.md)

គម្រោងនេះបង្ហាញពីការផ្ញើ និងទទួល JSON Messages តាមរយៈ KafkaTemplate និង `@KafkaListener`។

## របៀបដំណើរការ

```bash
# 1. បើក Zookeeper & Kafka តាម Docker
docker compose up -d

# 2. Run Spring Boot
mvn spring-boot:run
```

## តេស្តផ្ញើ Message:
```bash
curl -X POST "http://localhost:8080/api/v1/orders/create?email=dara@example.com&amount=150.00"
```
