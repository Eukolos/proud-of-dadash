package com.eukolos.restaurant.controler;

import com.eukolos.restaurant.dto.AccountDto;
import com.eukolos.restaurant.dto.ProductAddRequest;
import com.eukolos.restaurant.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<AccountDto>> getAllAccount(){
        return ResponseEntity.ok(service.getAllAccount());
    }

    @GetMapping("/{getTable}")
    public ResponseEntity<List<AccountDto>> getAllAccountOnTable(@PathVariable int getTable){
        return ResponseEntity.ok(service.getAllAccountOnTable(getTable));
    }

    @PostMapping("/order")
    public ResponseEntity<AccountDto> order(@RequestBody @Valid ProductAddRequest productAddRequest){
        return ResponseEntity.ok(service.addProduct(productAddRequest));
    }
}
