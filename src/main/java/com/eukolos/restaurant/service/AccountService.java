package com.eukolos.restaurant.service;


import com.eukolos.restaurant.dto.AccountCreateResponse;
import com.eukolos.restaurant.dto.AccountCreateResponseConverter;
import com.eukolos.restaurant.model.Account;
import com.eukolos.restaurant.model.Table;
import com.eukolos.restaurant.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository repository;
    private final TableService tableService;

    public AccountService(AccountRepository repository, TableService tableService) {
        this.repository = repository;
        this.tableService = tableService;
    }

    public AccountCreateResponse createAccount(int createAccountByTableNumberRequest){
        Optional<Account> isActive = repository.findByIsActive(true);
        Table table = new Table();
        table.setNumber(createAccountByTableNumberRequest);
        Account account = new Account();
        if (isActive.isEmpty()) {
            account.setActive(true);
            account.setTable(table);

            Account response = repository.save(account);

            AccountCreateResponse response2 = response.AccountCreateResponseConverter::convert;

        }



        return new AccountCreateResponse();

    }


}
