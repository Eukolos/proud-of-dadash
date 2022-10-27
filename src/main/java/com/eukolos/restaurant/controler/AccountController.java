package com.eukolos.restaurant.controler;

import com.eukolos.restaurant.dto.AccountDto;
import com.eukolos.restaurant.dto.ProductAddRequest;
import com.eukolos.restaurant.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping("/create/{createAccountRequest}")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDto createAccount(@PathVariable int createAccountRequest){
        return service.createAccount(createAccountRequest);
    }

    @GetMapping
    public List<AccountDto> getAllAccount(@RequestParam int pageNo, @RequestParam int pageSize){
        return service.getAllAccount(pageNo, pageSize);
    }

    @GetMapping("/active")
    public List<AccountDto> getAllActiveAccount(){
        return service.getAllActiveAccount();
    }

    @GetMapping("/{getTable}")
    public List<AccountDto> getAllAccountOnTable(@PathVariable int getTable){
        return service.getAllAccountOnTable(getTable);
    }

    @PostMapping("/order")
    public AccountDto order(@RequestBody @Valid ProductAddRequest productAddRequest){
        return service.addProduct(productAddRequest);
    }
}
