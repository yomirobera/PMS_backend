package com.example.pms.models.dto.chat;

import com.example.pms.models.User;
import lombok.Data;

import java.util.Set;

@Data
public class ChatPostDTO {
    private String timeStamp;
    private Set<User> users;
}
