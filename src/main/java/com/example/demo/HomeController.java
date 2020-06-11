package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserService userService;

    @Autowired
    CartRepository cartRepository;

    Cart cart = new Cart();

    @RequestMapping("/")
    public String listProduct(Model model, Principal principal){
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("cart", cart.getProducts().size());

        if(principal != null) {
            String username = principal.getName();
            model.addAttribute("user", customerRepository.findByUserName(username).getUserName());
        }
        else{
            model.addAttribute("user", "Guest");
        }

        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/profile")
    public String viewUserProfile(Model model, Principal principal){
        if(principal != null) {
            String username = principal.getName();
            model.addAttribute("user", customerRepository.findByUserName(username));
            model.addAttribute("userOrders", customerRepository.findByUserName(username).getOrders());
            model.addAttribute("products", orderRepository.findByCustomer(customerRepository.findByUserName(username)).getProducts());
            model.addAttribute("cart", cart.getProducts().size());
            model.addAttribute("orderRepository", orderRepository.findAll());
            return "userProfile";
        }
        else{
            return "redirect:/login";
        }

    }

    @RequestMapping("/register")
    public String newCustomerForm(Model model){
        model.addAttribute("newCustomer", new Customer());
        return "newCustomerForm";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@Valid @ModelAttribute("newCustomer") Customer customer,
                              BindingResult result){
        if(result.hasErrors()){
            customer.clearPassword();
            return "newCustomerForm";
        }
        customerRepository.save(customer);
        return "redirect:/login";
    }

    @GetMapping("/selectProduct/{id}")
    public String addProduct(@PathVariable("id") long id, Principal principal){
        if(principal == null){
            return "redirect:/login";
        }
        Product product = new Product();
        product.setAvailable(productRepository.findById(id).get().isAvailable());
        product.setProductName(productRepository.findById(id).get().getProductName());
        product.setProductType(productRepository.findById(id).get().getProductType());
        product.setPrice(productRepository.findById(id).get().getPrice());
        product.setCart(cart);
        cart.setProducts(product);
        cartRepository.save(cart);
        return "redirect:/";
    }

    @RequestMapping("/cart")
    public String viewCart(Model model, Principal principal){
        if(principal == null){
            return "redirect:/login";
        }
        String username = principal.getName();
        model.addAttribute("user", customerRepository.findByUserName(username));
        model.addAttribute("cart", cart.getProducts());
        double cartTotal = 0;
        double tax = 0.07;
        for(Product product: cart.getProducts()){
            cartTotal += product.getPrice();
        }
        model.addAttribute("totalBeforeTax", cartTotal);
        cartTotal = cartTotal*(1+tax);

        model.addAttribute("total", cartTotal);
        tax = cartTotal - cartTotal/(1+tax);
        model.addAttribute("tax", tax);
        return "cart";
    }

    @RequestMapping("/placeOrder")
    public String placeOrder(Model model, Principal principal){
        if(principal == null){
            return "redirect:/login";
        }
        String username = principal.getName();

        Order order = new Order();

        order.setProducts(cart.getProducts());
        order.setSubtotal(cart.getProducts());
        order.setCustomer(customerRepository.findByUserName(username));
        orderRepository.save(order);
        customerRepository.findByUserName(username).setOrders(order);
        customerRepository.save(customerRepository.findByUserName(username));

        model.addAttribute("order", cart.getProducts());
        model.addAttribute("orderSize", order.getProducts().size());
        model.addAttribute("orderPrice", order.getSubtotal());

        model.addAttribute("user", customerRepository.findByUserName(username));

        cart.getProducts().clear();
        return "orderConfirm";

    }

    @RequestMapping("/details/{id}")
    public String productDetailsView(@PathVariable("id")long id, Model model, Principal principal){
        String username = principal.getName();
        model.addAttribute("product", productRepository.findById(id).get());
        model.addAttribute("user", customerRepository.findByUserName(username));
        return "prodDetails";
    }

    @RequestMapping("/clearCart")
    public String clearCart(){
        cart.getProducts().clear();
        return "redirect:/";
    }

    @RequestMapping("/category/{type}")
    public String electronics(Principal principal, Model model, @PathVariable("type") String type){
        if(principal == null){
            return "redirect:/login";
        }
        String username = principal.getName();
        model.addAttribute("user", customerRepository.findByUserName(username).getUserName());
        model.addAttribute("cart", cart.getProducts().size());
        Set<Product> tempSet = new HashSet<>();
        for (Product product: productRepository.findAll()){
            if(product.getProductType().equals(type)){
                tempSet.add(product);
            }
        }
        model.addAttribute("products", tempSet);
        return "category";
    }



}
