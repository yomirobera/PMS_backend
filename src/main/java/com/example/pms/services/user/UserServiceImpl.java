package com.example.pms.services.user;

import com.example.pms.models.Project;
import com.example.pms.models.ToDo;
import com.example.pms.models.User;
import com.example.pms.repositories.ProjectRepository;
import com.example.pms.repositories.ToDoRepository;
import com.example.pms.repositories.UserRepository;
import org.springframework.stereotype.Service;
import com.example.pms.utils.exceptions.*;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final ToDoRepository toDoRepository;

    public UserServiceImpl(UserRepository userRepository, ProjectRepository projectRepository, ToDoRepository toDoRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.toDoRepository = toDoRepository;
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User add(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public void update(User entity) {
        userRepository.save(entity);
    }

    @Override
    public void deleteById(String id) {
        emptyToDoListById(id);
        removeFromProjects(id);
        userRepository.deleteById(id);

    }


    @Override
    public Set<ToDo> findToDoList(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return user.getToDoList();
    }
    @Override
    public Set<Project> findAllProjects(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return user.getProjects();
    }

//    @Override
    private void emptyToDoListById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        for (ToDo todo : user.getToDoList()) {
            toDoRepository.deleteById((todo.getId()));
        }
        user.setToDoList(new HashSet<>());
        userRepository.save(user);
    }

//    @Override
    private void removeFromProjects(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        for (Project project: user.getProjects()) {
            project.getUsers().remove(user);
            projectRepository.save(project);
        }
        user.setProjects(new HashSet<>());
        userRepository.save(user);

    }
}
