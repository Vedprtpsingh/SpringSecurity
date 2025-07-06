package com.ved.websecurityexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ved.websecurityexample.entity.EmployeeSignup;
import com.ved.websecurityexample.repo.EmployeeSignupRepo;


@Service
public class CustomUserDetailsSarvice implements UserDetailsService {
    @Autowired
    private EmployeeSignupRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmployeeSignup emp = repo.findByUsername(username);
        if(emp ==null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(emp.getUsername(),emp.getPassword(),List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
