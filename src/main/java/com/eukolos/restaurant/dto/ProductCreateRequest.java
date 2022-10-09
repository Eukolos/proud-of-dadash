package com.eukolos.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductCreateRequest {
    private String name;
    private double price;
}