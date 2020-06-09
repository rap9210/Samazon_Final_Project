package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Entity
@Table(name = "order_DB")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private double subtotal;

//    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Customer> customers;
//
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Customer customer;

    @ManyToMany(mappedBy = "order_id")
    private Set<Customer> customers;

//    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Product> products;
//
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Product product;

    @ManyToMany(mappedBy = "order_id")
    private Set<Product> products;


    public Order() {
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products.add(products);
    }

    public long getId() {
        return id;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}