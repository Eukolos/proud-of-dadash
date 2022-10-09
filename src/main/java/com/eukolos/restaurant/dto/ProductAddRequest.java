package com.eukolos.restaurant.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductAddRequest {
    private String productId;
    private String accountId;
    private double amount;
}
