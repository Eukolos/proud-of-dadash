package com.eukolos.restaurant.controller;

import com.eukolos.restaurant.dto.AccountDto;
import com.eukolos.restaurant.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/req")
public class AccountController {
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }
    @PostMapping
    public AccountDto createAccount() {


        return service.createAccount(5);
    }

}
