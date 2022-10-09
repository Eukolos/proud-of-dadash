package com.eukolos.restaurant.controler;

import com.eukolos.restaurant.dto.AccountDto;
import com.eukolos.restaurant.model.Account;
import com.eukolos.restaurant.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/create/{createAccountRequest}")
    public AccountDto createAccount(@PathVariable int createAccountRequest){
        return service.createAccount(createAccountRequest);
    };

    @GetMapping
    public List<AccountDto> getAllAccount(){
        return service.getAllAccount();
    }

    @GetMapping("/{getTable}")
    public List<AccountDto> getAllAccountOnTable(@PathVariable int getTable){
        return service.getAllAccountOnTable(getTable);
    }
}
