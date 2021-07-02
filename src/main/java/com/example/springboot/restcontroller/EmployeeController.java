package com.example.springboot.restcontroller;

import com.example.springboot.entity.Employee;
import com.example.springboot.exception.EmployeeNotFoundException;
import com.example.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return employeeService.retrieveEmployees();
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
        try {
            if (!employee.isPresent()) {
                throw new EmployeeNotFoundException(employeeId);
            }
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
