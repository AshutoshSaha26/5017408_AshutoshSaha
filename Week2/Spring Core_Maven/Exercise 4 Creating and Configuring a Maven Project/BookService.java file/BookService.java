package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

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
