package com.example.pms.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @Column(unique = true, nullable = false, updatable = false)
    private Integer id;

    @Column(length = 50,nullable = false)
    private String firstname;
    @Column(length = 50,nullable = false)

    private String lastname;
    @Column(length = 50,nullable = false)

    private String email;
    @Column(length = 50)

    private String todolist;

    @ManyToMany
    @JoinTable(name = "user_projects",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects;

    @ManyToMany
    @JoinTable(
            name = "user_chats",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "chat_id")}
    )
    private Set<Chat> chats;

}