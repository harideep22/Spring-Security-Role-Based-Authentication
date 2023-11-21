package com.example.Spring.security.acciojob.dbms.repository;

import com.example.Spring.security.acciojob.dbms.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee> findByEmployeeName(String employeeName);

}
