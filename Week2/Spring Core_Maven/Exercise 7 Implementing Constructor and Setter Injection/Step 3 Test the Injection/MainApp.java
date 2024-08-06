// MainApp.java
package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("bookService");
        bookService.printWelcomeMessage();
        bookService.performOperation();

        // Testing setter injection
        BookService bookService2 = new BookService(null);
        bookService2.setBookRepository((BookRepository) context.getBean("bookRepository"));
        bookService2.performOperation();
    }
}
