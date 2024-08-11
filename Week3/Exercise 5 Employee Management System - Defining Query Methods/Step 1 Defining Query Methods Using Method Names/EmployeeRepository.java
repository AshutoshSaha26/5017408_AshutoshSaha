package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employees by name
    List<Employee> findByName(String name);

    // Find employees by email
    Employee findByEmail(String email);

    // Find employees by name and email
    List<Employee> findByNameAndEmail(String name, String email);

    // Find employees whose name contains a specific string
    List<Employee> findByNameContaining(String keyword);
}
