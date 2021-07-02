package com.example.springboot.restcontroller;

import com.example.springboot.entity.Employee;
import com.example.springboot.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> retrieveEmployees() {
        List<Employee> employees = employeeService.retrieveEmployees();
        return employees;
    }

    @GetMapping("/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable Long employeeId) {
        Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
        return employee;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{employeeId}")
    public void updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) {
        Optional<Employee> existingEmployee = employeeService.getEmployeeById(employeeId);
        existingEmployee.ifPresent(e -> {
            e.setName(employee.getName());
            e.setEmail(employee.getEmail());
            e.setRole(employee.getRole());
            employeeService.updateEmployee(e);
        });
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}
