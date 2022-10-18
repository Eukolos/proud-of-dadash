package com.eukolos.restaurant.data_seed;

import com.eukolos.restaurant.model.Product;
import com.eukolos.restaurant.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@RequiredArgsConstructor
public class ProductSeed implements CommandLineRunner {
    private final ProductRepository productRepository;

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
