package com.eukolos.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductDto {
    private String id;
    private String name;
    private double amount;
    private double price;
}