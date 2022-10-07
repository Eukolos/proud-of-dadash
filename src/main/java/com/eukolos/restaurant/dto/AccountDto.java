package com.eukolos.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Data @NoArgsConstructor @AllArgsConstructor
public class AccountDto {
    private String id;
    private Boolean isActive;
    private List<ProductDto> products;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}