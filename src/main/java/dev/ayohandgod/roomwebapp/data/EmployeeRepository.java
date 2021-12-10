package dev.ayohandgod.roomwebapp.data;

import dev.ayohandgod.roomwebapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
