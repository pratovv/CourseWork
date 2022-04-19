package com.example.smartrep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerTodo {
    private Long id;
    private Long userId;
    private String title;
    private String description;
    private Boolean status;
    private String date;
}
