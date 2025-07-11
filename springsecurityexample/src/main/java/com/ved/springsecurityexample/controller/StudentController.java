package com.ved.springsecurityexample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ved.springsecurityexample.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>(List.of(
        new Student(1, "Ved", "100"),
        new Student(2, "Vedant", "99"),
        new Student(3, "Vedika", "98"),
        new Student(4, "Vedaant", "97"),
        new Student(5, "Vanshika", "96")
    ));
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }
    @GetMapping("/csrf-token")
    public CsrfToken csrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}
