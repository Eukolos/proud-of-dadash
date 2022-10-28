package com.eukolos.restaurant.service;

import com.eukolos.restaurant.model.Employee;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final EmployeeService employeeService;

    public UserDetailsServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeService.findEmployeeByUsername(username);
        //SimpleGrantedAuthority role = new SimpleGrantedAuthority(employee.getRole().name());
        List<SimpleGrantedAuthority> roles = Stream.of(employee.getRole())
                .map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
        return new User(
                employee.getUsername(),
                employee.getPassword(),
                roles);
    }
}
