package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    public UserService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    public Customer findByEmail(String email)
    {
        return customerRepository.findByEmail(email);
    }

    public Long countById(Long id)
    {
        return customerRepository.countById(id);
    }

    public Customer findByUsername(String username)
    {
        return customerRepository.findByUserName(username);
    }


    // returns currently logged in user
    public Customer getUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentUsername = authentication.getName();

        Customer customer = customerRepository.findByUserName(currentUsername);

        return customer;
    }

}
