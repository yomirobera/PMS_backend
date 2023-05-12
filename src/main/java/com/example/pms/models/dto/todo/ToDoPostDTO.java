package com.example.pms.models.dto.todo;

import lombok.Data;

import java.util.Date;

@Data
public class ToDoPostDTO {
    private String title;

    private String category;

    private Date date;
}
