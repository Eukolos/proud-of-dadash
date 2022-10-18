package com.eukolos.restaurant.controler;

import com.eukolos.restaurant.dto.AccountDto;
import com.eukolos.restaurant.dto.ProductAddRequest;
import com.eukolos.restaurant.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

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

    @PostMapping("/order")
    public AccountDto order(@RequestBody ProductAddRequest productAddRequest){
        return service.addProduct(productAddRequest);
    };
}
