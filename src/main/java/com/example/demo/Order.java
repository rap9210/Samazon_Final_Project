package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "order_db")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "subtotal")
    private double subtotal;

    private double total;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Set<Product> products;

    public Order() {
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public long getId() {
        return id;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Set<Product> products) {
        double order_total = 0;
        for(Product product: products){
            order_total += product.getPrice();
        }
        this.subtotal = order_total;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public void setProducts(Product product) {
//        this.products.add(product);
//    }
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}