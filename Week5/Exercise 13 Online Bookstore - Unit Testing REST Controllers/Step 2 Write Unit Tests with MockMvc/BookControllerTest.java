package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetBookById() throws Exception {
        Book book = new Book(1L, "Book Title", "Book Author", 29.99, "1234567890");
        given(bookService.getBookById(1L)).willReturn(book);

        mockMvc.perform(get("/api/v1/books/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.title").value("Book Title"))
            .andExpect(jsonPath("$.author").value("Book Author"))
            .andExpect(jsonPath("$.price").value(29.99));
    }

    @Test
    public void testCreateBook() throws Exception {
        Book book = new Book(null, "New Book", "New Author", 19.99, "0987654321");
        Book savedBook = new Book(2L, "New Book", "New Author", 19.99, "0987654321");
        given(bookService.createBook(book)).willReturn(savedBook);

        mockMvc.perform(post("/api/v1/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(book)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(2))
            .andExpect(jsonPath("$.title").value("New Book"));
    }

    @Test
    public void testUpdateBook() throws Exception {
        Book book = new Book(1L, "Updated Title", "Updated Author", 24.99, "1234567890");
        given(bookService.updateBook(1L, book)).willReturn(book);

        mockMvc.perform(put("/api/v1/books/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(book)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.title").value("Updated Title"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        mockMvc.perform(delete("/api/v1/books/1"))
            .andExpect(status().isNoContent());
    }
}
