package com.example.smartrep.dto;

import com.example.smartrep.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    private String login;
    private String password;
    private String name;
    private String surname;
    private int salary;
    private UserRole userRole;
}
