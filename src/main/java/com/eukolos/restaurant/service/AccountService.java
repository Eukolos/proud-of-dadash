package com.eukolos.restaurant.service;


import com.eukolos.restaurant.dto.AccountDto;
import com.eukolos.restaurant.dto.AccountDtoConverter;
import com.eukolos.restaurant.model.Account;
import com.eukolos.restaurant.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository repository;
    private final AccountDtoConverter accountDtoConverter;

    public AccountService(AccountRepository repository, AccountDtoConverter accountDtoConverter) {
        this.repository = repository;
        this.accountDtoConverter = accountDtoConverter;
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






}
