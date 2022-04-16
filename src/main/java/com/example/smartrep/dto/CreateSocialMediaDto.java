package com.example.smartrep.dto;

import com.example.smartrep.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSocialMediaDto {
    private String image;
    private String socialMedia;
    private Long people;
    private Long money;
}
