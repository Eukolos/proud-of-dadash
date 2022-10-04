package com.eukolos.restaurant.service;

import com.eukolos.restaurant.dto.AccountDto;
import com.eukolos.restaurant.model.Account;
import com.eukolos.restaurant.model.Table;
import com.eukolos.restaurant.repository.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository repository;
    private final TableService tableService;

    public AccountService(AccountRepository repository, TableService tableService) {
        this.repository = repository;
        this.tableService = tableService;
    }

    public AccountDto createAccount (int tableNumber){
       ResponseEntity<Table> table = tableService.tableNumber(tableNumber);
       Account account = new Account();
       account.setActive(true);
       account.setTable(table.getBody().getId());
       Account response = repository.save(account);

       AccountDto accountDto = new AccountDto();
       accountDto.setId(response.getId());
       accountDto.setIsActive(response.getActive());
       accountDto.setTable(response.getTable());
       accountDto.setCreatedAt(response.getCreatedAt());
       accountDto.setUpdatedAt(response.getUpdatedAt());
       return accountDto;
    }



}
