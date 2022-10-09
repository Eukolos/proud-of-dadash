package com.eukolos.restaurant.dto;

import com.eukolos.restaurant.model.Account;
import com.eukolos.restaurant.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDtoConverter {
private final ProductDtoConverter productDtoConverter;

    public AccountDtoConverter(ProductDtoConverter productDtoConverter) {
        this.productDtoConverter = productDtoConverter;
    }


    public AccountDto convert(Account account){
        List<ProductDto> productDtoList = new ArrayList<>();
        if(account.getProducts() != null)
             for (Product product: account.getProducts()) {
           productDtoList.add(productDtoConverter.convert(product));
        }

         AccountDto accountDto = AccountDto.builder()
                .id(account.getId())
                .isActive(account.getIsActive())
                .tableNumber(account.getTableNumber())
                .createdAt(account.getCreatedAt())
                .updatedAt(account.getUpdatedAt())
                .products(productDtoList)
                .build();

        return accountDto;
    }
}
