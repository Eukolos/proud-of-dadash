package com.eukolos.restaurant.dto;

import com.eukolos.restaurant.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountCreateResponseConverter  {

    public AccountCreateResponse convert(Account account) {
        TableAccountCreateResponse tableAccountCreateResponse = new TableAccountCreateResponse();
        tableAccountCreateResponse.setId(account.getTable().getId());
        tableAccountCreateResponse.setNumber(account.getTable().getNumber());
        AccountCreateResponse accountCreateResponse = new AccountCreateResponse();
        accountCreateResponse.setId(account.getId());
        accountCreateResponse.setIsActive(account.getActive());
        accountCreateResponse.setTable(tableAccountCreateResponse);
        accountCreateResponse.setCreatedAt(account.getCreatedAt());
        accountCreateResponse.setUpdatedAt(account.getUpdatedAt());

        return accountCreateResponse;
    }
}