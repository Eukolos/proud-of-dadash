package com.eukolos.restaurant.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductCreateRequest {
    @NotEmpty
    private String name;
    @Min(0)
    private double price;
}