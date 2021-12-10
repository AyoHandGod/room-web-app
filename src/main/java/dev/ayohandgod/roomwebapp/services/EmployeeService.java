package dev.ayohandgod.roomwebapp.services;

import dev.ayohandgod.roomwebapp.data.EmployeeRepository;
import dev.ayohandgod.roomwebapp.models.Employee;
import dev.ayohandgod.roomwebapp.models.Position;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
