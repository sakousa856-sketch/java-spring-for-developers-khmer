package com.example.bookstore.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BookResponse(
    Long id,
    String title,
    String author,
    String isbn,
    BigDecimal price,
    LocalDateTime createdAt
) {}
