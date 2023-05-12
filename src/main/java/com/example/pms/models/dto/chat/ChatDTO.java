package com.example.pms.models.dto.chat;

import lombok.Data;

import java.util.Set;

@Data
public class ChatDTO {
    private int id;
    private String timeStamp;
    private Set<String> users;
}
