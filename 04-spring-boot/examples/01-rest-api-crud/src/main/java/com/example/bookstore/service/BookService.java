package com.example.bookstore.service;

import com.example.bookstore.dto.BookResponse;
import com.example.bookstore.dto.CreateBookRequest;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<BookResponse> getAllBooks() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public BookResponse getBookById(Long id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new NoSuchElementException("Book not found with ID: " + id));
    }

    public BookResponse createBook(CreateBookRequest request) {
        Book book = new Book(
                null,
                request.title(),
                request.author(),
                request.isbn(),
                request.price(),
                LocalDateTime.now()
        );
        Book saved = repository.save(book);
        return toResponse(saved);
    }

    public BookResponse updateBook(Long id, CreateBookRequest request) {
        Book existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Book not found with ID: " + id));
        existing.setTitle(request.title());
        existing.setAuthor(request.author());
        existing.setIsbn(request.isbn());
        existing.setPrice(request.price());
        return toResponse(repository.save(existing));
    }

    public void deleteBook(Long id) {
        if (!repository.deleteById(id)) {
            throw new NoSuchElementException("Book not found with ID: " + id);
        }
    }

    private BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPrice(),
                book.getCreatedAt()
        );
    }
}
