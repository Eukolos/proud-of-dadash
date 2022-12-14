package com.eukolos.restaurant.data_seed;

import com.eukolos.restaurant.model.Employee;
import com.eukolos.restaurant.model.Product;
import com.eukolos.restaurant.model.Role;
import com.eukolos.restaurant.repository.EmployeeRepository;
import com.eukolos.restaurant.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@RequiredArgsConstructor
public class ProductSeed implements CommandLineRunner {
    private final PasswordEncoder passwordEncoder;

    private final ProductRepository productRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        Employee e1 = Employee.builder()
                .username("emin")
                .password(passwordEncoder.encode("123123"))
                .role(Role.ADMIN)
                .build();
        Employee e2 = Employee.builder()
                .username("ali")
                .password(passwordEncoder.encode("123123"))
                .role(Role.ADMIN)
                .build();
        Employee e3 = Employee.builder()
                .username("veli")
                .password(passwordEncoder.encode("123123"))
                .role(Role.ADMIN)
                .build();
        employeeRepository.saveAll(Arrays.asList(e1,e2,e3));


        Product p1 = Product.builder()
                .name("Döner")
                .price(15)
                .uniquee(true)
                .build();
        Product p2 = Product.builder()
                .name("Pilav")
                .price(30)
                .uniquee(true)
                .build();
        Product p3 = Product.builder()
                .name("Kanat")
                .price(50)
                .uniquee(true)
                .build();
        Product p4 = Product.builder()
                .name("İskender")
                .price(60)
                .uniquee(true)
                .build();
        Product p5 = Product.builder()
                .name("Tavuk Wrap")
                .price(40)
                .uniquee(true)
                .build();
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

    }
}