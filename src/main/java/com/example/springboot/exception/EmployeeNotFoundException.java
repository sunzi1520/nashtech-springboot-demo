package com.example.springboot.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(long id) {
        super("Employee with the id " + id + " not found.");
    }
}
