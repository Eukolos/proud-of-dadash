package com.eukolos.restaurant.dto.request;

import com.eukolos.restaurant.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeCreateRequest {

        private String username;

        private String password;

        private Role role;
}
