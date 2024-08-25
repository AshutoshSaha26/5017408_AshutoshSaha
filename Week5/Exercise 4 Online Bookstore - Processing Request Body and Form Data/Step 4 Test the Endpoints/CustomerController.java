package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    // POST - Create a new customer using JSON request body
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    // POST - Register a customer using form data
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password) {

        Customer customer = new Customer(null, name, email, password);
        customers.add(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    // GET - Retrieve all customers (for testing)
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
