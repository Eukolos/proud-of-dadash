package com.eukolos.restaurant;

import com.eukolos.restaurant.model.Product;
import com.eukolos.restaurant.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class RestaurantApplication implements CommandLineRunner{

    private final ProductRepository productRepository;

    public RestaurantApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(RestaurantApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Product p1 = Product.builder()
                .name("Döner")
                .price(15)
                .build();
        Product p2 = Product.builder()
                .name("Pilav")
                .price(30)
                .build();
        Product p3 = Product.builder()
                .name("Kanat")
                .price(50)
                .build();
        Product p4 = Product.builder()
                .name("İskender")
                .price(60)
                .build();
        Product p5 = Product.builder()
                .name("Tavuk Wrap")
                .price(40)
                .build();
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

    }
}
