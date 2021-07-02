package com.example.springboot.entity;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @SequenceGenerator(name="employees_seq",sequenceName="employees_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="employees_seq")
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_email")
    private String email;

    @Column(name = "employee_role")
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
