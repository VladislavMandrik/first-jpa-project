package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final String EXCEPTION_MESSAGE = "Employee not found for this id :: ";

    @Autowired
    EmployeeRepository repository;

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        Employee employeeInDb = repository.findById(id).orElseThrow(() ->
                new RuntimeException(EXCEPTION_MESSAGE + id));

        if (employee.getEmailId() != null) {
            employeeInDb.setEmailId(employee.getEmailId());
        }

        if (employee.getLastName() != null) {
            employeeInDb.setLastName(employee.getLastName());
        }

        if (employee.getFirstName() != null) {
            employeeInDb.setFirstName(employee.getFirstName());
        }

        return repository.save(employeeInDb);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return repository.findAll();
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException
                (EXCEPTION_MESSAGE + id));
    }

    @Override
    public Optional<Employee> findEmployeeByName(String firstName) {
        return repository.findByFirstName(firstName);
    }
}
