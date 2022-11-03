package com.eukolos.restaurant.dto.converter;

import com.eukolos.restaurant.dto.EmployeeDto;
import com.eukolos.restaurant.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDtoConverter {

    public List<EmployeeDto> convertAll(List<Employee> employees) {

        List<EmployeeDto> EmployeeDtoList = new ArrayList<>();
        for (Employee employee: employees) {
            EmployeeDtoList.add(convert(employee));
        }
        return EmployeeDtoList;
    }
    public EmployeeDto convert(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .username(employee.getUsername())
                .role(employee.getRole())
                .build();
    }
}
