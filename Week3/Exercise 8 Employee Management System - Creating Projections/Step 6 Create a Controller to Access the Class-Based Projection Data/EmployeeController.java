package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.projection.EmployeeDetailsDTO;
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

    // Fetch class-based projection
    @GetMapping("/details")
    public ResponseEntity<List<EmployeeDetailsDTO>> getEmployeeDetails() {
        List<EmployeeDetailsDTO> employeeDetails = employeeRepository.findEmployeeDetails();
        return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
    }
}
