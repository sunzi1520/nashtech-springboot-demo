package com.example.springboot.service.impl;

import com.example.springboot.entity.Employee;
import com.example.springboot.repository.EmployeeRepository;
import com.example.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> retrieveEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public Optional<Employee> getEmployeeById(Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) { employeeRepository.save(employee); }
}
