// BookService.java
package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to the Library Management System!");
    }

    public void performOperation() {
        System.out.println("Performing a library operation...");
    }
}
