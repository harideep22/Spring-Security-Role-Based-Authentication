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
        try {
            // Assuming employeeRepository.findByEmployeeName returns an Optional<Employee>
            Optional<Employee> userInfo = employeeRepository.findByEmployeeName(username);

            // Check if the result is present
            if (userInfo.isPresent()) {
                // Transform Employee to UserInfoUserDetails manually
                Employee employee = userInfo.get();
                UserInfoUserDetails userDetails = new UserInfoUserDetails(employee);

                return userDetails;
            } else {
                // Throw an exception if the user is not found
                throw new UsernameNotFoundException("User not found: " + username);
            }
        } catch (Exception e) {
            // Handle any other exceptions that might occur
            throw new RuntimeException("Error retrieving user information", e);
        }
    }


}


