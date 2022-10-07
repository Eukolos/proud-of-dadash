package com.eukolos.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data @NoArgsConstructor @AllArgsConstructor
public class ProductDto {
    private String id;
    private String name;
    private double amount;
    private double price;
}