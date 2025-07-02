package com.ved.springsecurityexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ved.springsecurityexample.model.UserPrincipal;
import com.ved.springsecurityexample.model.Users;
import com.ved.springsecurityexample.repo.UserRepo;

@Service
public class MyuserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Users user=repo.findByUsername(username);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User Not Found");
        }
        return new UserPrincipal(user);
    }
}
