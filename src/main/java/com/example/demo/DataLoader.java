package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void run(String... String) throws Exception {


        Customer customer1 = new Customer();
        customer1.setRoles("Admin");
        customer1.setFirstName("Eyob");
        customer1.setLastName("Amenu");
        customer1.setAddress("1 Circle Ave");
        customer1.setEmail("eyob@123");
        customer1.setPhone(1234567890);
        customer1.setPassword("eyob");
        customer1.setUser_name("eyob");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setRoles("Admin");
        customer2.setFirstName("Ronald");
        customer2.setLastName("Ronald");
        customer2.setAddress("10 Circle Ave");
        customer2.setEmail("ronald@123");
        customer2.setPhone(1234567890);
        customer2.setPassword("ronald");
        customer2.setUser_name("ronald");
        customerRepository.save(customer2);

        Product product1 = new Product();
        product1.setProduct_type("Electronics");
        product1.setProduct_name("Computer");
        product1.setPrice(399.99);
        product1.setAvailable(true);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setProduct_type("Jewelery");
        product2.setProduct_name("Gold Watch");
        product2.setPrice(1399.99);
        product2.setAvailable(true);
        productRepository.save(product2);

//        Order order1 = new Order();
//        order1.setCustomer(customer1);
//        order1.setProducts(product1);
//        order1.setProducts(product2);
//        order1.setSubtotal(product1.getPrice() + product2.getPrice());
//        orderRepository.save(order1);
//
//        Order order2 = new Order();
//        order2.setCustomer(customer2);
//        order2.setProducts(product2);
//        order2.setSubtotal(product2.getPrice());
//        orderRepository.save(order2);




    }
}
