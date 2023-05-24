package com.example.pms.models.dto.user;

import com.example.pms.models.Chat;
import com.example.pms.models.Project;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Integer> toDoList;
    private Set<Integer> projects;
    private Set<Integer> chats;

}
