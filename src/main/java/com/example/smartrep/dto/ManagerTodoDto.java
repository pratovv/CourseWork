package com.example.smartrep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerTodoDto {
    private Long user;
    private String title;
    private String description;
}
