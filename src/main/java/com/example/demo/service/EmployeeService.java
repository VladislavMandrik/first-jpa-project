package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    void delete(Long id);

    Employee update(Long id, Employee employee);

    Employee save(Employee employee);

    List<Employee> findAllEmployee();

    Employee findEmployeeById(Long id);

    Optional<Employee> findEmployeeByName(String firstName);
}
