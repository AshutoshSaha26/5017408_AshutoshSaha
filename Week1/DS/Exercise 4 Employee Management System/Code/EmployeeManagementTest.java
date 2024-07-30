public class EmployeeManagementTest {
    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement(5);

        // Adding employees
        management.addEmployee(new Employee(1, "John Doe", "Manager", 75000));
        management.addEmployee(new Employee(2, "Jane Smith", "Developer", 60000));
        management.addEmployee(new Employee(3, "Emily Johnson", "Analyst", 50000));

        // Traversing employees
        System.out.println("All Employees:");
        management.traverseEmployees();

        // Searching for an employee
        System.out.println("\nSearching for employee with ID 2:");
        Employee employee = management.searchEmployee(2);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }

        // Deleting an employee
        System.out.println("\nDeleting employee with ID 2:");
        if (management.deleteEmployee(2)) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }

        // Traversing employees after deletion
        System.out.println("\nAll Employees after deletion:");
        management.traverseEmployees();
    }
}
