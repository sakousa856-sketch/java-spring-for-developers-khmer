# គម្រោងគំរូ: E-Commerce Microservices Architecture (Spring Cloud)

[English Version](./README.md)

គម្រោងនេះរួមបញ្ចូលសេវាកម្មទាំង ៤ ក្នុងស្ថាបត្យកម្ម Microservices៖
1. **Eureka Server (Port 8761):** Service Registry & Discovery
2. **API Gateway (Port 8080):** Spring Cloud Gateway (Single Entry Point)
3. **Product Service (Port 8081):** Product Catalog & Stock
4. **Order Service (Port 8082):** Order Management using OpenFeign Client calling Product Service

## របៀបដំណើរការជាមួយ Docker Compose

```bash
docker compose up --build
```

- Eureka Dashboard: `http://localhost:8761`
- Gateway Root: `http://localhost:8080`
