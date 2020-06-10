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

    Set<Product> cart = new HashSet<>();

    @RequestMapping("/")
    public String listProduct(Model model, Principal principal){
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("cart", cart.size());

        if(principal != null) {
            String username = principal.getName();
            model.addAttribute("user", customerRepository.findByUserName(username).getUserName());
        }
        else{
            model.addAttribute("user", "Guest");
        }

        return "listProducts";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
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
    public String addProduct(@PathVariable("id") long id){
        cart.add(productRepository.findById(id).get());
        return "redirect:/";
    }

    @RequestMapping("/checkout")
    public String orderPage(Model model){
        Order newOrder = new Order();
        newOrder.setProducts(cart);
        newOrder.setSubtotal(cart);
        newOrder.setCustomer(userService.getUser());
        orderRepository.save(newOrder);
        model.addAttribute("order", orderRepository);
        return "listOrder";
    }
}
