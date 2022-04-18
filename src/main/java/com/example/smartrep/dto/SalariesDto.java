package com.example.smartrep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalariesDto {
    private String name;
    private Long sum;
}
