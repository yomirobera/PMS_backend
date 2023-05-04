package com.example.pms.models.dto.user;

import lombok.Data;

@Data
public class UserUpdateDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
