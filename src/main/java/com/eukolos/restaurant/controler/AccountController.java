package com.eukolos.restaurant.controler;

import com.eukolos.restaurant.dto.AccountDto;
import com.eukolos.restaurant.dto.request.PaymentRequest;
import com.eukolos.restaurant.dto.response.PaymentResponse;
import com.eukolos.restaurant.dto.request.ProductAddRequest;
import com.eukolos.restaurant.service.AccountService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/approved")
    public List<AccountDto> approvedList(){
        return service.approvedList();
    }

    @PutMapping("/preparing/{id}")
    public AccountDto preparing(@PathVariable String id){
        return service.preparing(id);
    }

    @GetMapping("/preparing")
    public List<AccountDto> preparingList(){
        return service.preparingList();
    }

    @PutMapping("/readyforpickup/{id}")
    public AccountDto readyForPickUp(@PathVariable String id){
        return service.readyForPickUp(id);
    }

    @GetMapping("/readyforpickup")
    public List<AccountDto> readyforpickup(){
        return service.readyForPickUpList();
    }

    @PutMapping("/delivered/{id}")
    public AccountDto delivered(@PathVariable String id){
        return service.delivered(id);
    }

    @PutMapping("/cancelled/{id}")
    public AccountDto cancelled(@PathVariable String id){
        return service.cancelled(id);
    }

    @GetMapping("/bill/{accountId}")
    public String getBill(@PathVariable String accountId){

        return "total price: " + service.bill(accountId);
    }

    @PutMapping("/bill/payment")
    public PaymentResponse payment(@RequestBody @Valid PaymentRequest paymentRequest){
        return service.payment(paymentRequest);
    }
}
