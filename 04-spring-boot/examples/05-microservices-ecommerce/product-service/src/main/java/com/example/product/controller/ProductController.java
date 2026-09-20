package com.example.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    public record ProductDto(Long id, String name, BigDecimal price, Integer stock) {}

    private final List<ProductDto> products = List.of(
        new ProductDto(101L, "MacBook Pro M3", new BigDecimal("1999.00"), 15),
        new ProductDto(102L, "Keychron K2 Keyboard", new BigDecimal("89.00"), 40),
        new ProductDto(103L, "Logitech MX Master 3S", new BigDecimal("99.00"), 25)
    );

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return products.stream()
            .filter(p -> p.id().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
