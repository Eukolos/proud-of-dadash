package com.eukolos.restaurant.service;


import com.eukolos.restaurant.dto.AccountCreateResponse;
import com.eukolos.restaurant.model.Account;
import com.eukolos.restaurant.model.Table;
import com.eukolos.restaurant.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository repository;
    private final TableService service;

    public AccountService(AccountRepository repository, TableService service) {
        this.repository = repository;
        this.service = service;
    }

    public Account createAccount(int createAccountByTableNumberRequest) {
        Boolean isActive = service.tableIsActive(createAccountByTableNumberRequest);
        if (isActive){
            return new Account();
        }
        Table table = new Table();
        table.setNumber(createAccountByTableNumberRequest);
        Account account = new Account();
        account.setActive(true);
        account.setTable(table);
        Account response = repository.save(account);


        return response;
    }


}

/*
Table table = new Table();
        table.setNumber(createAccountByTableNumberRequest);
        Account account = new Account();
        if (isActive.isEmpty()) {
            account.setActive(true);
            account.setTable(table);
            Account response = repository.save(account);

            TableAccountCreateResponse tableAccountCreateResponse = new TableAccountCreateResponse();
            tableAccountCreateResponse.setId(response.getTable().getId());
            tableAccountCreateResponse.setNumber(response.getTable().getNumber());
            AccountCreateResponse accountCreateResponse = new AccountCreateResponse();
            accountCreateResponse.setId(response.getId());
            accountCreateResponse.setIsActive(response.getActive());
            accountCreateResponse.setTable(tableAccountCreateResponse);
            accountCreateResponse.setCreatedAt(response.getCreatedAt());
            accountCreateResponse.setUpdatedAt(response.getUpdatedAt());

            return accountCreateResponse;
        }
        return new AccountCreateResponse();
    }
*/