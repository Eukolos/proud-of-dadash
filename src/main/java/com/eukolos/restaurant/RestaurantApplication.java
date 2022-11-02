package com.eukolos.restaurant;

import com.eukolos.restaurant.model.Employee;
import com.eukolos.restaurant.model.Product;
import com.eukolos.restaurant.model.Role;
import com.eukolos.restaurant.repository.EmployeeRepository;
import com.eukolos.restaurant.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class RestaurantApplication  {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantApplication.class, args);
    }



}
