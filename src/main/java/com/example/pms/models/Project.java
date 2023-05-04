package com.example.pms.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String type;
    @Column(length = 50)
    private String description;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date startDate;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dueDate;

    private String phase;

    @ManyToMany(mappedBy = "projects")
    private Set<User> users;
}
