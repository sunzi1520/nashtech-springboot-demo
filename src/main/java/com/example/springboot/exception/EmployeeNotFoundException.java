package com.example.springboot.exception;

public class EmployeeNotFoundException extends RuntimeException {
    EmployeeNotFoundException(long id) {
        super("Employee with the id " + id + " not found.");
    }
}
