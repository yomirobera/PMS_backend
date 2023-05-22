package com.example.pms.services.user;

import com.example.pms.models.Project;
import com.example.pms.models.ToDo;
import com.example.pms.models.User;
import com.example.pms.services.CrudService;

import java.util.Set;

public interface UserService extends CrudService <User, String> {
    Set<ToDo> findToDoList(String id);
    Set<Project> findAllProjects(String id);
}
