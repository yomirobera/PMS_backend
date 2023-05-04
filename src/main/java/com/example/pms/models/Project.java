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
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String type;

    private String description;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date StartDate;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date DueDate;

    private String Phase;

    //Many to Many
    @ManyToMany(mappedBy = "Project")
    private Set<User> user;
}
