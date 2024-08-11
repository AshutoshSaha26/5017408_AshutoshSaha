package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT new com.example.EmployeeManagementSystem.projection.EmployeeDetailsDTO(e.name, e.email, d.name) " +
           "FROM Employee e JOIN e.department d")
    List<EmployeeDetailsDTO> findEmployeeDetails();
}
