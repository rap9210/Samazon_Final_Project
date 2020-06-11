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
        customer1.setPhone("1234567890");
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
        customer2.setPhone("1234567890");
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

        Product product3 = new Product();
        product3.setProductType("Jewelery");
        product3.setProductName("Silver Watch");
        product3.setPrice(1255.99);
        product3.setAvailable(true);
        productRepository.save(product3);

        Product product4 = new Product();
        product4.setProductType("Jewelery");
        product4.setProductName("Bronze Watch");
        product4.setPrice(1125.99);
        product4.setAvailable(true);
        productRepository.save(product4);

        Product product5 = new Product();
        product5.setProductType("Jewelery");
        product5.setProductName("Digital Watch");
        product5.setPrice(499.99);
        product5.setAvailable(true);
        productRepository.save(product5);

        Product product6 = new Product();
        product6.setProductType("Jewelery");
        product6.setProductName("Diamond Watch");
        product6.setPrice(1749.99);
        product6.setAvailable(true);
        productRepository.save(product6);

        Product product7 = new Product();
        product7.setProductType("Electronics");
        product7.setProductName("1TB Hard Drive");
        product7.setPrice(199.99);
        product7.setAvailable(true);
        productRepository.save(product7);

        Product product8 = new Product();
        product8.setProductType("Electronics");
        product8.setProductName("500GB SSD");
        product8.setPrice(399.99);
        product8.setAvailable(true);
        productRepository.save(product8);

        Product product9 = new Product();
        product9.setProductType("Electronics");
        product9.setProductName("1TB SSD");
        product9.setPrice(799.99);
        product9.setAvailable(true);
        productRepository.save(product9);

        Product product10 = new Product();
        product10.setProductType("Electronics");
        product10.setProductName("I5 Processor");
        product10.setPrice(250.99);
        product10.setAvailable(true);
        productRepository.save(product10);

        Product product11 = new Product();
        product11.setProductType("Electronics");
        product11.setProductName("I7 Processor");
        product11.setPrice(399.99);
        product11.setAvailable(true);
        productRepository.save(product11);

        Product product12 = new Product();
        product12.setProductType("Electronics");
        product12.setProductName("I3 Processor");
        product12.setPrice(174.99);
        product12.setAvailable(true);
        productRepository.save(product12);

        Product product13 = new Product();
        product13.setProductType("Electronics");
        product13.setProductName("Keyboard");
        product13.setPrice(49.99);
        product13.setAvailable(true);
        productRepository.save(product13);

        Product product14 = new Product();
        product14.setProductType("Electronics");
        product14.setProductName("Computer Mouse");
        product14.setPrice(25.99);
        product14.setAvailable(true);
        productRepository.save(product14);

        Product product15 = new Product();
        product15.setProductType("Home and Auto");
        product15.setProductName("Air Freshener");
        product15.setPrice(7.99);
        product15.setAvailable(true);
        productRepository.save(product15);

        Product product16 = new Product();
        product16.setProductType("Home and Auto");
        product16.setProductName("Carpet");
        product16.setPrice(49.99);
        product16.setAvailable(true);
        productRepository.save(product16);

        Product product17 = new Product();
        product17.setProductType("Home and Auto");
        product17.setProductName("Radio");
        product17.setPrice(149.99);
        product17.setAvailable(true);
        productRepository.save(product17);

        Product product18 = new Product();
        product18.setProductType("Home and Auto");
        product18.setProductName("Seat Covers");
        product18.setPrice(39.99);
        product18.setAvailable(true);
        productRepository.save(product18);

        Product product19 = new Product();
        product19.setProductType("Home and Auto");
        product19.setProductName("Decal");
        product19.setPrice(43.99);
        product19.setAvailable(true);
        productRepository.save(product19);

        Product product20 = new Product();
        product20.setProductType("Home and Auto");
        product20.setProductName("Car Battery");
        product20.setPrice(70.99);
        product20.setAvailable(false);
        productRepository.save(product20);

    }
}
