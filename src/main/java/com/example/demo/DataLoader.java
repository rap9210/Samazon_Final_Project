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
        customer1.setUserName("eyob");
        customer1.setCardNumber(123456);
        customer1.setNameOnCard("eyob");
        customer1.setExpirationDate("06/2020");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setRoles("Admin");
        customer2.setFirstName("Ronald");
        customer2.setLastName("Ronald");
        customer2.setAddress("10 Circle Ave");
        customer2.setEmail("ronald@123");
        customer2.setPhone(1234567890);
        customer2.setPassword("ronald");
        customer2.setUserName("ronald");
        customer2.setCardNumber(123456);
        customer2.setNameOnCard("ronald");
        customer2.setExpirationDate("06/2020");
        customerRepository.save(customer2);

        Product product1 = new Product();
        product1.setProductType("Electronics");
        product1.setProductName("Computer");
        product1.setPrice(399.99);
        product1.setAvailable(true);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setProductType("Jewelery");
        product2.setProductName("Gold Watch");
        product2.setPrice(1399.99);
        product2.setAvailable(true);
        productRepository.save(product2);

    }
}
