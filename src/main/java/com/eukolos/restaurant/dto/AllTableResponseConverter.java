package com.eukolos.restaurant.dto;

import com.eukolos.restaurant.model.Account;
import com.eukolos.restaurant.model.Table;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllTableResponseConverter {

    public AllTableResponse convert(Table table ) {

        List<AccountIdResponse> convertedAccounts = new ArrayList<>();

        AllTableResponse allTableResponse = new AllTableResponse();
        allTableResponse.setId(table.getId());
        allTableResponse.setNumber(table.getNumber());
        StaticGetAccountId(table, convertedAccounts);
        allTableResponse.setAccountList(convertedAccounts);


        return allTableResponse;
    }

    private static void StaticGetAccountId(Table table, List<AccountIdResponse> convertedAccounts) {
        for( Account account : table.getAccountList()) {
            AccountIdResponseConverter converter = new AccountIdResponseConverter();
            convertedAccounts.add(converter.convert(account));
        }
    }
}
//tableList.stream().map(allTableResponseConverter::convert).collect(Collectors.toList())

//table.getAccountList().stream().map(AccountIdResponseConverter::convert).collect(Collectors.toList())