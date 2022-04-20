package com.example.smartrep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TodoEmployeeDto {
    private Long managerId;
    private Long employeeId;
    private String title;
    private String description;
}
