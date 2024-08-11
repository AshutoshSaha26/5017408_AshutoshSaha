package com.example.EmployeeManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
@NamedQueries({
    @NamedQuery(
        name = "Employee.findByDepartmentName",
        query = "SELECT e FROM Employee e WHERE e.department.name = :deptName"
    ),
    @NamedQuery(
        name = "Employee.findByEmailAndName",
        query = "SELECT e FROM Employee e WHERE e.email = :email AND e.name = :name"
    )
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Getters and setters...
}
