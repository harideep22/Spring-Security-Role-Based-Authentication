package com.example.Spring.security.acciojob.dbms.service;

import com.example.Spring.security.acciojob.dbms.model.Employee;
import com.example.Spring.security.acciojob.dbms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    public void addEmployee(Employee employee) {

        String password= passwordEncoder.encode(employee.getEmployeePassword());
        employee.setEmployeePassword(password);

        employeeRepository.save(employee);

    }


}
