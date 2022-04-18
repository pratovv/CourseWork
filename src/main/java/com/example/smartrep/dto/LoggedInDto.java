package com.example.smartrep.dto;

import com.example.smartrep.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoggedInDto {
    private Long id;
    private Long salary;
    private String name;
    private UserRole userRole;

}
