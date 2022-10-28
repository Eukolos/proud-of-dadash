package com.eukolos.restaurant.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PaymentResponse {
    private String statement;
    private Double balance;
}
