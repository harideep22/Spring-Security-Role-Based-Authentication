package com.example.Spring.security.acciojob.dbms.controller;

import com.example.Spring.security.acciojob.dbms.model.Employee;
import com.example.Spring.security.acciojob.dbms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return "Successfully Added Employee";
    }

    @GetMapping("/getAdmin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String HelloByAdmin(){

        return "Helloo By Admin";
    }

    @GetMapping("/getStudent")
    @PreAuthorize("hasAuthority('STUDENT')")
    public String HelloByStudent(){
        return "Hello By Student";
    }

}
