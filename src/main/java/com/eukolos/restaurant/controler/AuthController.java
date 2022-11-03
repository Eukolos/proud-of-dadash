package com.eukolos.restaurant.controler;

import com.eukolos.restaurant.dto.EmployeeDto;
import com.eukolos.restaurant.dto.request.EmployeeCreateRequest;
import com.eukolos.restaurant.dto.request.LoginRequest;
import com.eukolos.restaurant.dto.response.LoginResponse;
import com.eukolos.restaurant.service.AuthService;
import com.eukolos.restaurant.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final EmployeeService employeeService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto createEmployee(@RequestBody EmployeeCreateRequest employeeCreateRequest){
        return employeeService.createEmployee(employeeCreateRequest);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }


}
