package com.eukolos.restaurant.dto;

import com.eukolos.restaurant.model.Account;
import org.springframework.stereotype.Component;

@Component
public class TableAccountCreateResponseConverter {

    public AccountIdResponse convert(Account account) {

        AccountIdResponse accountIdResponse = new AccountIdResponse();
        accountIdResponse.setId(account.getId());
        accountIdResponse.setActive(account.getActive());
        accountIdResponse.setCreatedAt(account.getCreatedAt());
        accountIdResponse.setUpdatedAt(account.getUpdatedAt());

        return accountIdResponse;
    }
}