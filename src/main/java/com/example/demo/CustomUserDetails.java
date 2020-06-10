package com.example.demo;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomUserDetails extends org.springframework.security.core.userdetails.User {
    private Customer customer;

    public CustomUserDetails(Customer customer, Collection<? extends GrantedAuthority> authorities){
        super(customer.getUserName(),
                customer.getPassword(),
                authorities);

        this.customer = customer;
    }

    public CustomUserDetails(Customer customer, String password, Collection<?
            extends GrantedAuthority> authorities){
        super(customer.getUserName(),
                password,
                authorities);

        this.customer = customer;
    }

    public CustomUserDetails(Customer customer, boolean enabled,
                             boolean accountNonExpired,
                             boolean credentialsNonExpired,
                             boolean accountNonLocked,
                             Collection<?
                                     extends GrantedAuthority> authorities){
        super(customer.getUserName(),
                customer.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                authorities);

        this.customer = customer;

    }

    public Customer getUser() {
        return customer;
    }

}
