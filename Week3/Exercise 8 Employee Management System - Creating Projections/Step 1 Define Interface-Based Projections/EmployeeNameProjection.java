package com.example.EmployeeManagementSystem.projection;

public interface EmployeeNameProjection {
    String getName();
    String getEmail();
    String getDepartmentName();

    interface DepartmentName {
        String getName();
    }
}
