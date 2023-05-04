package com.example.pms.models.dto.chat;

import com.example.pms.models.User;
import lombok.Data;

import java.util.Set;

@Data
public class ChatDTO {
    private int id;
    private String timeStamp;
    private Set<User> users;
}
