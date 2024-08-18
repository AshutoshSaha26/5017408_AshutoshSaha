package com.example.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)  // Ignore unknown properties
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
}
