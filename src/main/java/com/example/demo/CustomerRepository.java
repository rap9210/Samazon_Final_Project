package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByUserName(String username);
    Customer findByEmail(String email);
    Long countById(Long id);
}
