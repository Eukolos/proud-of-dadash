package com.eukolos.restaurant.service;

import com.eukolos.restaurant.dto.EmployeeDtoConverter;
import com.eukolos.restaurant.dto.LoginRequest;
import com.eukolos.restaurant.dto.LoginResponse;
import com.eukolos.restaurant.exception.NotFoundException;
import com.eukolos.restaurant.utils.TokenGenerator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final EmployeeService employeeService;
    private final TokenGenerator tokenGenerator;
    private final AuthenticationManager authenticationManager;
    private final EmployeeDtoConverter employeeDtoConverter;

    public AuthService(EmployeeService employeeService, TokenGenerator tokenGenerator, AuthenticationManager authenticationManager, EmployeeDtoConverter employeeDtoConverter) {
        this.employeeService = employeeService;
        this.tokenGenerator = tokenGenerator;
        this.authenticationManager = authenticationManager;
        this.employeeDtoConverter = employeeDtoConverter;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()));
            return LoginResponse.builder()
                    .accessToken(tokenGenerator.generateToken(auth))
                    .employeeDto(employeeDtoConverter.convert(employeeService.findEmployeeByUsername(loginRequest.getUsername())))
                    .build();
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }

    }
}
