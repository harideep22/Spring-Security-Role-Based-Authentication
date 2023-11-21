package com.example.Spring.security.acciojob.dbms.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name = "employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int employeeId;
    @Column(unique = true)
    String employeeName;

    String employeePassword;

    String employeeRole;

}
