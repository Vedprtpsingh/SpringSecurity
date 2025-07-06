package com.ved.websecurityexample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ved.websecurityexample.employee.Employee;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
    private List<Employee> List = new ArrayList<>(java.util.List.of(
        new Employee(11,"Dev",23),
        new Employee(12,"Ved",24),
        new Employee(13,"Ravi",25),
        new Employee(14,"Rohit",26),
        new Employee(15,"Rohan",27)
    ));
    @GetMapping("/home")
    public String hello() {
        return "Learning Spring Security with Ved";
    }
    public List<Employee> getEmployee() {
        return List;
    }
    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return List;
    }
    @PostMapping("/add")
    public void add(@RequestBody Employee employee){
        List.add(employee);
    }
    @GetMapping("/csrf")
    public CsrfToken session(HttpServletRequest req) {
        return (CsrfToken)req.getAttribute("_csrf");
    }
}
