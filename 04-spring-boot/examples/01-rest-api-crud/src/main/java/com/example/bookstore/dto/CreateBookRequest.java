package com.example.bookstore.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record CreateBookRequest(
    @NotBlank(message = "Title is required and cannot be blank")
    String title,

    @NotBlank(message = "Author is required")
    String author,

    @NotBlank(message = "ISBN is required")
    String isbn,

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than zero")
    BigDecimal price
) {}
