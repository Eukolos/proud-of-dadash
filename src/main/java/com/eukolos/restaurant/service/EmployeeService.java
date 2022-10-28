package com.eukolos.restaurant.service;

import com.eukolos.restaurant.dto.EmployeeCreateRequest;
import com.eukolos.restaurant.dto.EmployeeDto;
import com.eukolos.restaurant.dto.EmployeeDtoConverter;
import com.eukolos.restaurant.exception.NotFoundException;
import com.eukolos.restaurant.model.Employee;
import com.eukolos.restaurant.repository.EmployeeRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeDtoConverter employeeDtoConverter;
    private final PasswordEncoder passwordEncoder;

    public EmployeeService(EmployeeRepository repository, EmployeeDtoConverter employeeDtoConverter, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.employeeDtoConverter = employeeDtoConverter;
        this.passwordEncoder = passwordEncoder;
    }


    public EmployeeDto createEmployee(EmployeeCreateRequest request){
        Employee employee = new Employee();
        employee.setUsername(request.getUsername());
        employee.setPassword(passwordEncoder.encode(request.getPassword()));
        employee.setRole(request.getRole());

        return employeeDtoConverter.convert(repository.save(employee));
    }

    public Employee findEmployeeByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(
                () -> new NotFoundException("no account with this username: "+username+" was found" )
        );
    }

}
