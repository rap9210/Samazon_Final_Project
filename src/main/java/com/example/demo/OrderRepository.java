package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Order findAllByCustomer(Customer customer);

}
