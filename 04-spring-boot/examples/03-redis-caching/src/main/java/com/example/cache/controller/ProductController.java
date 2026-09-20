package com.example.cache.controller;

import com.example.cache.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductService.ProductDto getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}/cache")
    public String clearCache(@PathVariable Long id) {
        productService.evictProduct(id);
        return "Cache evicted for product " + id;
    }
}
