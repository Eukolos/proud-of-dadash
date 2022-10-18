package com.eukolos.restaurant.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductAddRequest {
    @NotBlank
    private String productId;
    @NotBlank
    private String accountId;
    @Min(0)
    private double amount;
}
