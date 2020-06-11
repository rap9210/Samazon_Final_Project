package com.example.demo;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart_db")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double subtotal;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Product> productSet = new HashSet<>();


    public Cart() {
    }

    public Cart(Set<Product> products) {
        this.productSet = products;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Set<Product> products) {
        double order_total = 0;
        for(Product p : products){
            order_total += p.getPrice();
        }
        this.subtotal = order_total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Product> getProducts() {
        return productSet;
    }

    public void setProducts(Product product) {
        this.productSet.add(product);
    }
}
