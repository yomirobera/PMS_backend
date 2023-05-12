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
@Table(name = "todo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String category;
    @Column(length = 50, nullable = false)
    private String priorityLvl;


    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date date;

    @ManyToMany(mappedBy = "projects")
    private Set<User> users;
}
