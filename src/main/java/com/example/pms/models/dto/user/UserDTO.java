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
    private Set<String> toDoList;
    private Set<Project> projects;
    private Set<Chat> chats;

}
