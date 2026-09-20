package com.example.todo.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record CreateTodoRequest(
    @NotBlank(message = "Title must not be blank")
    String title,
    String description
) {}
