package com.ved.websecurityexample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ved.websecurityexample.entity.EmployeeSignup;

@Repository
public interface EmployeeSignupRepo extends JpaRepository<EmployeeSignup, Integer> {
    EmployeeSignup findByUsername(String userName);
}
