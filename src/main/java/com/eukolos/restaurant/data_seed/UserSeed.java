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
public class UserSeed implements CommandLineRunner {
    private final PasswordEncoder passwordEncoder;

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


    }
}
