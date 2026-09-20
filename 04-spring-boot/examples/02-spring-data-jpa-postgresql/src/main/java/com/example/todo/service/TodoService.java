package com.example.todo.service;

import com.example.todo.dto.CreateTodoRequest;
import com.example.todo.dto.TodoResponse;
import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<TodoResponse> getTodos(Boolean completed) {
        List<Todo> list = (completed != null) 
                ? repository.findByCompleted(completed)
                : repository.findAll();
        return list.stream().map(this::toDto).toList();
    }

    public TodoResponse createTodo(CreateTodoRequest request) {
        Todo todo = new Todo(request.title(), request.description());
        return toDto(repository.save(todo));
    }

    public TodoResponse toggleCompleted(Long id) {
        Todo todo = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Todo not found: " + id));
        todo.setCompleted(!todo.isCompleted());
        return toDto(todo);
    }

    public void deleteTodo(Long id) {
        repository.deleteById(id);
    }

    private TodoResponse toDto(Todo t) {
        return new TodoResponse(t.getId(), t.getTitle(), t.getDescription(), t.isCompleted(), t.getCreatedAt());
    }
}
