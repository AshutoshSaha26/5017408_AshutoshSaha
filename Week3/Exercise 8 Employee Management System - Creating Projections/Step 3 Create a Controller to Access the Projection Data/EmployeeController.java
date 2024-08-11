package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.projection.EmployeeNameProjection;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Fetch specific fields using projection
    @GetMapping("/names-and-emails")
    public ResponseEntity<List<EmployeeNameProjection>> getEmployeeNamesAndEmails() {
        List<EmployeeNameProjection> employees = employeeRepository.findEmployeeNamesAndEmails();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
