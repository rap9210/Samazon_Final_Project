package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.text.DecimalFormat;
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
    Search search = new Search();

    @RequestMapping("/")
    public String listProduct(Model model, Principal principal){
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("cart", cart.getProducts().size());
//        model.addAttribute("search", new Search());
        if(principal != null) {
            String username = principal.getName();
            model.addAttribute("user", customerRepository.findByUserName(username).getUserName());
            model.addAttribute("userRole", customerRepository.findByUserName(username).getRoles());
        }
        else{
            model.addAttribute("user", "Guest");
        }

        return "home";
    }

//    @PostMapping("/search")
//    public String searchProductRepository(Model model, @ModelAttribute("newSearch")Search search){
//        Set<Product> tempSet = new HashSet<>();
//
//        for(Product product: productRepository.findAll()){
//            if(product.getProductName().contains(search.getSearch())){
//                tempSet.add(product);
//            }
//        }
//        model.addAttribute("products", tempSet);
//        return "home";
//
//    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/logout")
    public String logout(){return "redirect:/login?logout=true";}

    @RequestMapping("/profile")
    public String viewUserProfile(Model model, Principal principal){
        if(principal != null) {
            String username = principal.getName();
            model.addAttribute("user", customerRepository.findByUserName(username));
            model.addAttribute("userOrders", customerRepository.findByUserName(username).getOrders());

//            model.addAttribute("products", orderRepository.findAllByCustomer(customerRepository.findByUserName(username)));
            model.addAttribute("cart", cart.getProducts().size());
            model.addAttribute("orderRepository", orderRepository.findAll());
            return "userProfile";
        }
        else{
            return "redirect:/login";
        }

    }

    @GetMapping("/addProduct")
    public String addProductForm(Model model, Principal principal){
        String username = principal.getName();
        model.addAttribute("user", customerRepository.findByUserName(username));
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String processNewProduct(@Valid @ModelAttribute("newProduct") Product product, BindingResult result){
        if(result.hasErrors()){
            return "addProduct";
        }
        else{
            productRepository.save(product);
            return "redirect:/";
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
//        Product product = new Product();
//        product.setAvailable(productRepository.findById(id).get().isAvailable());
//        product.setProductName(productRepository.findById(id).get().getProductName());
//        product.setProductType(productRepository.findById(id).get().getProductType());
//        product.setPrice(productRepository.findById(id).get().getPrice());
//        product.setCart(cart);
        cart.setProducts(productRepository.findById(id).get());
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
        double shipping = 20;
        for(Product product: cart.getProducts()){
            cartTotal += product.getPrice();
        }
        if(cartTotal > 50){
            shipping = 0;
        }
        model.addAttribute("totalBeforeTax", cartTotal);
        cartTotal = cartTotal*(1+tax);
        model.addAttribute("shipping", shipping);
        cartTotal += shipping;
        model.addAttribute("total", cartTotal);
        tax = cartTotal - cartTotal/(1+tax);
        model.addAttribute("tax", tax);
        cart.setTotal(cartTotal);
        cartRepository.save(cart);
        return "cart";
    }

    @RequestMapping("/placeOrder")
    public String placeOrder(Model model, Principal principal){
        if(principal == null){
            return "redirect:/login";
        }
        String username = principal.getName();

        Order order = new Order();

//        for(Product product: cart.getProducts()){
//            order.setProducts(product);
//            orderRepository.save(order);
//        }
        order.setProducts(cart.getProducts());
        orderRepository.save(order);
        order.setTotal(cart.getTotal());
        orderRepository.save(order);
        order.setCustomer(customerRepository.findByUserName(username));
        orderRepository.save(order);
        customerRepository.findByUserName(username).setOrders(order);
        customerRepository.save(customerRepository.findByUserName(username));

        model.addAttribute("order", cart.getProducts());
        model.addAttribute("orderSize", order.getProducts().size());
        model.addAttribute("orderPrice", order.getTotal());

        model.addAttribute("user", customerRepository.findByUserName(username));

        cart.getProducts().clear();
        return "orderConfirm";

    }

    @RequestMapping("/details/{id}")
    public String productDetailsView(@PathVariable("id")long id, Model model, Principal principal){
        String username = principal.getName();
        model.addAttribute("product", productRepository.findById(id).get());
        model.addAttribute("user", customerRepository.findByUserName(username));
        model.addAttribute("cart", cart.getProducts().size());
        return "prodDetails";
    }

    @RequestMapping("/clearCart")
    public String clearCart(){
        cart.getProducts().clear();
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
        }
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

//    public static double roundAvoid(double value, int places){
//        double scale = Math.pow(10, places);
//
//        return Math.round(value*scale) / scale;
//    }


}
