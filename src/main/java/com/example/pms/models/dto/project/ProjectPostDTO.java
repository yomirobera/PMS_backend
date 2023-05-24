package com.example.pms.models.dto.project;

import com.example.pms.models.User;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class ProjectPostDTO {
    private String title;
    private String type;
    private String description;
    private Date startDate;
    private Date dueDate;
    private String phase;
    private Set<String> users;
}
