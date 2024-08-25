package com.example.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)  // Exclude null values
public class BookDTO {
    private Long id;

    @JsonProperty("book_title")  // Custom field name in JSON
    private String title;

    private String author;
    private Double price;
    private String isbn;
}
