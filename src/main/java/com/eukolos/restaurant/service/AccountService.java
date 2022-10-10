package com.eukolos.restaurant.service;


import com.eukolos.restaurant.dto.*;
import com.eukolos.restaurant.model.Account;
import com.eukolos.restaurant.model.Product;
import com.eukolos.restaurant.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class AccountService {
    private final AccountRepository repository;
    private final ProductService productService;
    private final AccountDtoConverter accountDtoConverter;
    private final ProductDtoConverter productDtoConverter;

    public AccountService(AccountRepository repository, ProductService productService, AccountDtoConverter accountDtoConverter, ProductDtoConverter productDtoConverter) {
        this.repository = repository;
        this.productService = productService;
        this.accountDtoConverter = accountDtoConverter;
        this.productDtoConverter = productDtoConverter;
    }

    public AccountDto createAccount(int createAccountRequest){
        Account account = new Account();
        account.setIsActive(true);
        account.setTableNumber(createAccountRequest);
        Account response = repository.save(account);

        return accountDtoConverter.convert(response);
    }

    public List<AccountDto> getAllAccount(){
        List<Account> accountList = repository.findAll();
        List<AccountDto> accountDtoList = new ArrayList<>();
        for (Account account: accountList) {
            accountDtoList.add(accountDtoConverter.convert(account));
        }

        return accountDtoList;
    }

    public List<AccountDto> getAllAccountOnTable(int tableRequest){
        Optional<List<Account>> accountList = repository.findByTableNumber(tableRequest);
        List<AccountDto> accountDtoList = new ArrayList<>();
        for (Account account: accountList.get()) {
            accountDtoList.add(accountDtoConverter.convert(account));
        }

        return accountDtoList;
    }

    public AccountDto addProduct(ProductAddRequest addProductRequest){
        ProductOrderRequest productOrderRequest = ProductOrderRequest.builder()
                .id(addProductRequest.getProductId())
                .amount(addProductRequest.getAmount())
                .build();
        Product product = productService.orderProduct(productOrderRequest);
        Account account = repository.findById(addProductRequest.getAccountId()).orElse(null);
        List<Product> products = account.getProducts();
        products.add(product);
        account.setProducts(products);
        Account response = repository.save(account);

        return accountDtoConverter.convert(response);
    }





}
