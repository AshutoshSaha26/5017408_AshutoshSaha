import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Use the named query defined in the Employee entity
    List<Employee> findByDepartmentName(@Param("deptName") String deptName);

    // Another named query
    List<Employee> findByEmailAndName(@Param("email") String email, @Param("name") String name);
}
