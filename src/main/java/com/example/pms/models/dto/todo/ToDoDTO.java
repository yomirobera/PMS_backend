package com.example.pms.models.dto.todo;

import lombok.Data;

import java.util.Date;

@Data
public class ToDoDTO {
    private Integer id;

    private String title;

    private String category;
    private String priorityLvl;


    private Date date;
}
