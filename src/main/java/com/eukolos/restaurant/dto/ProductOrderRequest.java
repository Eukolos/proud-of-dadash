package com.eukolos.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ProductOrderRequest {
    private String id;
    private double amount;
}