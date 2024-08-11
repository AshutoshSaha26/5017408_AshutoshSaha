package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Using projection to fetch specific fields
    @Query("SELECT e.name as name, e.email as email, d.name as departmentName FROM Employee e JOIN e.department d")
    List<EmployeeNameProjection> findEmployeeNamesAndEmails();
}
