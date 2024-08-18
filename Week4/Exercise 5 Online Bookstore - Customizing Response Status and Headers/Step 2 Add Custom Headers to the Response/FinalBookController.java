package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    // POST - Create a new book with custom status and header
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        books.add(book);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("X-Custom-Header", "CustomHeaderValue")
                .body(book);
    }

    // GET - Retrieve a single book by ID with custom status and header
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("X-Book-Error", "Book not found")
                    .build();
        }

        return ResponseEntity.ok()
                .header("X-Book-Header", "Fetched book details")
                .body(book);
    }

    // GET - Retrieve all books (for testing)
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
