package com.example.springboot.service;

import com.example.springboot.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> retrieveEmployees();

    public Optional<Employee> getEmployeeById(Long employeeId);

    public Employee saveEmployee(Employee employee);

    public void deleteEmployee(Long employeeId);

    public void updateEmployee(Employee employee);
}
