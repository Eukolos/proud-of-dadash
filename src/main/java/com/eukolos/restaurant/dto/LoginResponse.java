package com.eukolos.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class LoginResponse {
    private String accessToken;
    private EmployeeDto employeeDto;
}
