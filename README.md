# Project Relationship
##Customer Class
###@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
private Set<Order> orders;

###Order Class
###@ManyToOne(fetch = FetchType.EAGER)
###@JoinColumn(name = "customer_id")
private Customer customer;

###@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
private Set<Product> products;

###Products
###@ManyToOne(fetch = FetchType.EAGER)
###@JoinColumn(name = "order_id")
private order orders;


# test
