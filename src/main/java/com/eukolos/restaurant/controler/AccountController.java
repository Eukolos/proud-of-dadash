package com.eukolos.restaurant.controler;

import com.eukolos.restaurant.dto.AccountCreateResponse;
import com.eukolos.restaurant.model.Account;
import com.eukolos.restaurant.service.AccountService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Account")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/create/{createAccountByTableNumberRequest}")
    public Account newAccount(@PathVariable int createAccountByTableNumberRequest){
       return service.createAccount(createAccountByTableNumberRequest);
    };
}
