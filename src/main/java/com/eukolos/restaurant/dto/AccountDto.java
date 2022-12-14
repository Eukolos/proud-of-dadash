package com.eukolos.restaurant.dto;

import com.eukolos.restaurant.model.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AccountDto {
    private String id;
    private Boolean isActive;
    private int tableNumber;
    private List<ProductDto> products;
    private AccountStatus status;
    private Double totalPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}