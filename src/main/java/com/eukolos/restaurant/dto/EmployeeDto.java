package com.eukolos.restaurant.dto;

import com.eukolos.restaurant.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeDto {

    private String id;

    private String username;

    private Role role;

}
