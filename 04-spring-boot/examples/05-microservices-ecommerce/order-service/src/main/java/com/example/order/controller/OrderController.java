package com.example.order.controller;

import com.example.order.client.ProductClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final ProductClient productClient;

    public OrderController(ProductClient productClient) {
        this.productClient = productClient;
    }

    public record CreateOrderRequest(Long productId, Integer quantity) {}

    @PostMapping
    public ResponseEntity<Map<String, Object>> placeOrder(@RequestBody CreateOrderRequest request) {
        // Inter-service synchronous call via OpenFeign with Eureka discovery!
        ProductClient.ProductDto product = productClient.getProductById(request.productId());
        
        BigDecimal total = product.price().multiply(BigDecimal.valueOf(request.quantity()));

        return ResponseEntity.ok(Map.of(
            "orderId", UUID.randomUUID().toString(),
            "status", "CONFIRMED",
            "createdAt", LocalDateTime.now().toString(),
            "productName", product.name(),
            "unitPrice", product.price(),
            "quantity", request.quantity(),
            "totalAmount", total
        ));
    }
}
