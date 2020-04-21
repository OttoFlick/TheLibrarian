package pl.coderslab.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.library.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
