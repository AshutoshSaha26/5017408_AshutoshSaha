package com.example.bookstoreapi;

import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        bookRepository.deleteAll();
    }

    @Test
    public void testCreateBook() throws Exception {
        Book book = new Book(null, "New Book", "New Author", 19.99, "0987654321");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(book)))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("New Book"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("New Author"));
    }

    @Test
    public void testGetBookById() throws Exception {
        Book book = new Book(null, "Sample Book", "Sample Author", 29.99, "1234567890");
        Book savedBook = bookRepository.save(book);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/" + savedBook.getId()))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Sample Book"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("Sample Author"));
    }

    @Test
    public void testUpdateBook() throws Exception {
        Book book = new Book(null, "Update Book", "Update Author", 25.99, "0987654321");
        Book savedBook = bookRepository.save(book);
        savedBook.setTitle("Updated Title");

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/books/" + savedBook.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(savedBook)))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Updated Title"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        Book book = new Book(null, "Book to Delete", "Author", 15.99, "1122334455");
        Book savedBook = bookRepository.save(book);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/books/" + savedBook.getId()))
            .andExpect(MockMvcResultMatchers.status().isNoContent());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/" + savedBook.getId()))
            .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
