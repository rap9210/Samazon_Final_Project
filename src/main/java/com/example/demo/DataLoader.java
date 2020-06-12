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
        product1.setImageUrl("https://i.pcmag.com/imagery/reviews/05zKVE4qnORysT6djhLeZZd-41..v_1578361275.jpg");
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setProductType("Jewelery");
        product2.setProductName("Gold Watch");
        product2.setPrice(1399.99);
        product2.setAvailable(true);
        product2.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/91aVTs5XjiL._AC_UY500_.jpg");

        productRepository.save(product2);

        Product product3 = new Product();
        product3.setProductType("Jewelery");
        product3.setProductName("Silver Watch");
        product3.setPrice(1255.99);
        product3.setAvailable(true);
        product3.setImageUrl("https://www.nixon.com/on/demandware.static/-/Sites-masterCatalog_Nixon/default/dwd0bb7832/products/A045-1920-view1.png");
        productRepository.save(product3);

        Product product4 = new Product();
        product4.setProductType("Jewelery");
        product4.setProductName("Bronze Watch");
        product4.setPrice(1125.99);
        product4.setAvailable(true);
        product4.setImageUrl("https://secure-journal.hautehorlogerie.org/wp-content/uploads/2019/06/Panerai-Submersible-Bronzo.jpg");
        productRepository.save(product4);

        Product product5 = new Product();
        product5.setProductType("Jewelery");
        product5.setProductName("Digital Watch");
        product5.setPrice(499.99);
        product5.setAvailable(true);
        product5.setImageUrl("https://www.ripcurl.com/media/catalog/product/a/3/a3199_cob-1.jpg");

        productRepository.save(product5);

        Product product6 = new Product();
        product6.setProductType("Jewelery");
        product6.setProductName("Diamond Watch");
        product6.setPrice(1749.99);
        product6.setAvailable(true);
        product6.setImageUrl("https://d1251d0o0760fi.cloudfront.net/catalog/product/i/c/iced-out-diamond-rolex-watch-for-men-datejust-with-diamond-bezel-face-20c_main.jpg");

        productRepository.save(product6);

        Product product7 = new Product();
        product7.setProductType("Electronics");
        product7.setProductName("1TB Hard Drive");
        product7.setPrice(199.99);
        product7.setAvailable(true);
        product7.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/61%2BD1lyvOPL.__AC_SY300_QL70_ML2_.jpg");

        productRepository.save(product7);

        Product product8 = new Product();
        product8.setProductType("Electronics");
        product8.setProductName("500GB SSD");
        product8.setPrice(399.99);
        product8.setAvailable(true);
        product8.setImageUrl("https://www.bhphotovideo.com/images/images2500x2500/samsung_mz_76q1t0b_am_1tb_860_qvo_sata_1448944.jpg");

        productRepository.save(product8);

        Product product9 = new Product();
        product9.setProductType("Electronics");
        product9.setProductName("1TB SSD");
        product9.setPrice(799.99);
        product9.setAvailable(true);
        product9.setImageUrl("https://www.bhphotovideo.com/images/images2500x2500/samsung_mz_76q1t0b_am_1tb_860_qvo_sata_1448944.jpg");

        productRepository.save(product9);

        Product product10 = new Product();
        product10.setProductType("Electronics");
        product10.setProductName("I5 Processor");
        product10.setPrice(250.99);
        product10.setAvailable(true);
        product10.setImageUrl("https://m.media-amazon.com/images/I/41i+sZeH71L._AC_SS350_.jpg");

        productRepository.save(product10);

        Product product11 = new Product();
        product11.setProductType("Electronics");
        product11.setProductName("I7 Processor");
        product11.setPrice(399.99);
        product11.setAvailable(true);
        product11.setImageUrl("https://i.ebayimg.com/images/g/IXMAAOSwG-1WuxkS/s-l300.jpg");

        productRepository.save(product11);

        Product product12 = new Product();
        product12.setProductType("Electronics");
        product12.setProductName("I3 Processor");
        product12.setPrice(174.99);
        product12.setAvailable(true);
        product12.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/41wHOMADfbL._SR600%2C315_PIWhiteStrip%2CBottomLeft%2C0%2C35_SCLZZZZZZZ_.jpg");

        productRepository.save(product12);

        Product product13 = new Product();
        product13.setProductType("Electronics");
        product13.setProductName("Keyboard");
        product13.setPrice(49.99);
        product13.setAvailable(true);
        product13.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/81PLqxtrJ3L._AC_SX425_.jpg");

        productRepository.save(product13);

        Product product14 = new Product();
        product14.setProductType("Electronics");
        product14.setProductName("Computer Mouse");
        product14.setPrice(25.99);
        product14.setAvailable(true);
        product14.setImageUrl("https://snpi.dell.com/snp/images/products/large/en-us~570-ABGP/570-ABGP.jpg");

        productRepository.save(product14);

        Product product15 = new Product();
        product15.setProductType("Home and Auto");
        product15.setProductName("Air Freshener");
        product15.setPrice(7.99);
        product15.setAvailable(true);
        product15.setImageUrl("https://www.dollargeneral.com/media/catalog/product/cache/0729a8e318a86bbdd225c6c8aa5967a3/0/4/046500008184_306003_1066810_v2-fw.jpg");
        productRepository.save(product15);

        Product product16 = new Product();
        product16.setProductType("Home and Auto");
        product16.setProductName("Carpet");
        product16.setPrice(49.99);
        product16.setAvailable(true);
        product16.setImageUrl("https://www.lloydmatsstore.com/pub/media/catalog/product/cache/66f87910f1ac367f2ef50980b009b1bc/b/e/berber2-1-hero.jpg");

        productRepository.save(product16);

        Product product17 = new Product();
        product17.setProductType("Home and Auto");
        product17.setProductName("Radio");
        product17.setPrice(149.99);
        product17.setAvailable(true);
        product17.setImageUrl("https://www.classentials.com/wp-content/uploads/2019/11/02-Grundig-WK-300-Weltklang-1-DIN-1975-BMW-Peugeot-Alfa-Romeo-classic-car-auto-radio-autoradio-classentials-01.jpg");

        productRepository.save(product17);

        Product product18 = new Product();
        product18.setProductType("Home and Auto");
        product18.setProductName("Seat Covers");
        product18.setPrice(39.99);
        product18.setAvailable(true);
        product18.setImageUrl("https://cdn.shopify.com/s/files/1/2652/6224/products/mm-car-seat-covers-99shirt_331_800x.jpg?v=1532756001");

        productRepository.save(product18);

        Product product19 = new Product();
        product19.setProductType("Home and Auto");
        product19.setProductName("Decal");
        product19.setPrice(43.99);
        product19.setAvailable(true);
        product19.setImageUrl("https://dejpknyizje2n.cloudfront.net/svgcustom/backgrounds/preview/navy-anchor-sticker-5492-81889-1572300748.6372564.jpg");

        productRepository.save(product19);

        Product product20 = new Product();
        product20.setProductType("Home and Auto");
        product20.setProductName("Car Battery");
        product20.setPrice(70.99);
        product20.setAvailable(false);
        product20.setImageUrl("https://i5.walmartimages.com/asr/5eb60f61-4034-4d2f-b637-befb4a88d13a_2.2aa9bc9d73aea118831a39d690a102ed.jpeg");

        productRepository.save(product20);

    }
}
