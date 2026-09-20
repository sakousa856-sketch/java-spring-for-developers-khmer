package com.example.cache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    public record ProductDto(Long id, String name, double price) implements Serializable {}

    @Cacheable(value = "products", key = "#id")
    public ProductDto getProductById(Long id) {
        log.info(">> Slow Database Query for Product ID: {} (Simulating 2 sec latency)", id);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}
        return new ProductDto(id, "Product #" + id, 99.99 * id);
    }

    @CacheEvict(value = "products", key = "#id")
    public void evictProduct(Long id) {
        log.info(">> Evicting cache for Product ID: {}", id);
    }
}
