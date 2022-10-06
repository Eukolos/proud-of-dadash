package com.eukolos.restaurant.service;

import com.eukolos.restaurant.dto.AllTableResponse;
import com.eukolos.restaurant.dto.AllTableResponseConverter;
import com.eukolos.restaurant.model.Account;
import com.eukolos.restaurant.model.Table;
import com.eukolos.restaurant.repository.TableRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.StyledEditorKit;
import java.security.PublicKey;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableService {
    private final TableRepository repository;
    private final AllTableResponseConverter allTableResponseConverter;

    public TableService(TableRepository repository, AllTableResponseConverter allTableResponseConverter) {
        this.repository = repository;
        this.allTableResponseConverter = allTableResponseConverter;
    }

    public List<AllTableResponse> getAllTable(){
        List<Table> tableList = repository.findAll();

        List<AllTableResponse> Response = tableList.stream().map(allTableResponseConverter::convert).collect(Collectors.toList());
        return Response;
    }

    public Boolean tableIsActive(int tableNumber){
       Table table = repository.findByNumber(tableNumber);
       for (Account account : table.getAccountList()) {
            if (account.getActive().equals(true)) {
                return true;
            }
        }
        return false;
    }

    public Table createAccountOnTable(int createAccountByTableNumberRequest){
        Boolean isActive = tableIsActive(createAccountByTableNumberRequest);
        if (isActive){
            return new Table();
        }
        Account account = new Account();
        account.setActive(true);
        Table table = repository.findByNumber(createAccountByTableNumberRequest);
        List<Account> accounts = table.getAccountList();
        accounts.add(account);
        table.setAccountList(accounts);

        Table response = repository.save(table);

        return response;




    }



 //   public TableResponse getTableById(String id) {return null }




}
