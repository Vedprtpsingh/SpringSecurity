package com.ved.websecurityexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ved.websecurityexample.entity.EmployeeSignup;
import com.ved.websecurityexample.repo.SignupRepo;

@RestController
public class SignupController {
    @Autowired
    private SignupRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @PostMapping("/signup")
    public String signup(@RequestBody EmployeeSignup employee) {
        employee.setPassword(encoder.encode(employee.getPassword()));
        try {
            repo.save(employee);
            return "Signup successful";
        } catch (Exception e) {
            return "Signup failed: " + e.getMessage();
        }
    }
}
