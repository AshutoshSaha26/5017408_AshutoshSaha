package com.example.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO {

    private Long id;

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    @JsonProperty("book_title")
    private String title;

    @NotBlank(message = "Author cannot be blank")
    private String author;

    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price must be positive")
    private Double price;

    private String isbn;
}
