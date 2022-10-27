package com.eukolos.restaurant.service;


import com.eukolos.restaurant.dto.*;
import com.eukolos.restaurant.exception.NotFoundException;
import com.eukolos.restaurant.exception.UnacceptablePaymentException;
import com.eukolos.restaurant.model.Account;
import com.eukolos.restaurant.model.Product;
import com.eukolos.restaurant.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repository;
    private final ProductService productService;
    private final AccountDtoConverter accountDtoConverter;


    public AccountDto createAccount(int createAccountRequest){
        Account account = new Account();
        account.setIsActive(true);
        account.setTotalPrice(0.0);
        account.setTableNumber(createAccountRequest);
        Account response = repository.save(account);

        return accountDtoConverter.convert(response);
    }

    public List<AccountDto> getAllAccount(int pageNo, int pageSize){
       /*
           https://vladmihalcea.com/spring-data-findall-anti-pattern/
           List<Account> accountList = repository.findAll();
           return accountDtoConverter.convertAll(accountList);
       */


        Sort updateSort = Sort.by("updatedAt");
        // create page request object
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, updateSort.descending());
        //pass it to repos
        Page<Account> pagingAccount = repository.findAll(pageRequest);
        //pagingAccount.hasContent(); -- to check pages are there or not
        return accountDtoConverter.convertAll(pagingAccount.get().collect(Collectors.toList()));

    }

    public List<AccountDto> getAllActiveAccount(){
        List<Account> accountList = repository.findByIsActive(true);
        return accountDtoConverter.convertAll(accountList);
    }

    public List<AccountDto> getAllAccountOnTable(int tableRequest){
        List<Account> accountList = repository.findByTableNumber(tableRequest);
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
        account.setTotalPrice(account.getTotalPrice() + product.getPrice()*product.getAmount());
        account.setProducts(products);
        Account response = repository.save(account);

        return accountDtoConverter.convert(response);
    }

    public double bill(String accountId){
        Account account = repository.findById(accountId)
                .orElseThrow(() -> new NotFoundException("no account with this id:"+accountId+" was found" ));

        return account.getTotalPrice();
    }

    public PaymentResponse payment(PaymentRequest paymentRequest) {
        Account account = repository.findById(paymentRequest.getAccountId())
                .orElseThrow(() -> new NotFoundException("no account with this id:"+paymentRequest.getAccountId()+" was found" ));
        account.setTotalPrice(account.getTotalPrice()- paymentRequest.getPayment());
        PaymentResponse response = new PaymentResponse();
        if (account.getTotalPrice() > 0) {
            response.setStatement("part of the payment has been paid");
            response.setBalance(account.getTotalPrice());
            repository.save(account);
        } else if (account.getTotalPrice() < 0) {
            throw new UnacceptablePaymentException("Paying too much is unacceptable");
        } else {
            response.setStatement("Payment has been completed");
            response.setBalance(account.getTotalPrice());
            account.setIsActive(false);
            repository.save(account);
        }
        return response;
    };





}
