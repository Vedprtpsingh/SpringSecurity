package com.ved.websecurityexample.repo;

import org.springframework.stereotype.Repository;

import com.ved.websecurityexample.entity.EmployeeSignup;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SignupRepo extends JpaRepository<EmployeeSignup, Integer> {
    
}
