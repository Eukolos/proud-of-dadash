package com.eukolos.restaurant.service;

import com.eukolos.restaurant.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeService.findEmployeeByUsername(username);
        SimpleGrantedAuthority role = new SimpleGrantedAuthority(employee.getRole().name());

        return new User(
                employee.getUsername(),
                employee.getPassword(),
                Collections.singleton(role));
    }
}
