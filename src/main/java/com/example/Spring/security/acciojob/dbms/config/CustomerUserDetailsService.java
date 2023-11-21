package com.example.Spring.security.acciojob.dbms.config;

import com.example.Spring.security.acciojob.dbms.controller.EmployeeController;
import com.example.Spring.security.acciojob.dbms.model.Employee;
import com.example.Spring.security.acciojob.dbms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Assuming employeeRepository.findByEmployeeName returns an Optional<Employee>
        Optional<Employee> userInfo = employeeRepository.findByEmployeeName(username);

        // Using map to convert Employee to UserInfoUserDetails, or throw an exception if not found
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

}
