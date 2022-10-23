package com.eukolos.restaurant.service;


import com.eukolos.restaurant.dto.*;
import com.eukolos.restaurant.exception.NotFoundException;
import com.eukolos.restaurant.model.Account;
import com.eukolos.restaurant.model.Product;
import com.eukolos.restaurant.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repository;
    private final ProductService productService;
    private final AccountDtoConverter accountDtoConverter;


    public AccountDto createAccount(int createAccountRequest){
        Account account = new Account();
        account.setIsActive(true);
        account.setTableNumber(createAccountRequest);
        Account response = repository.save(account);

        return accountDtoConverter.convert(response);
    }

    public List<AccountDto> getAllAccount(){
        // https://vladmihalcea.com/spring-data-findall-anti-pattern/
        List<Account> accountList = repository.findAll();
        return accountDtoConverter.convertAll(accountList);

       // return accountDtoList;
    }

    public List<AccountDto> getAllAccountOnTable(int tableRequest){
        List<Account> accountList = repository.findByTableNumber(tableRequest)
                .orElseThrow(() -> new NotFoundException("Table's accounts did not found"));
        return accountDtoConverter.convertAll(accountList);
    }

    public AccountDto addProduct(ProductAddRequest addProductRequest){
        ProductOrderRequest productOrderRequest = ProductOrderRequest.builder()
                .id(addProductRequest.getProductId())
                .amount(addProductRequest.getAmount())
                .build();
        Product product = productService.orderProduct(productOrderRequest);
        Account account = repository.findById(addProductRequest.getAccountId())
                .orElseThrow(() -> new NotFoundException("no account with this id:"+addProductRequest.getAccountId()+" was found" ));
        List<Product> products = account.getProducts();
        products.add(product);
        account.setProducts(products);
        Account response = repository.save(account);

        return accountDtoConverter.convert(response);
    }





}
