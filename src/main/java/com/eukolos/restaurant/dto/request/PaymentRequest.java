package com.eukolos.restaurant.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PaymentRequest {
    @NotEmpty
    private String accountId;
    @Min(0)
    private Double payment;
}
