package com.example.pms.services.project;

import com.example.pms.models.Project;
import com.example.pms.models.User;
import com.example.pms.repositories.ProjectRepository;
import com.example.pms.repositories.UserRepository;
import com.example.pms.utils.exceptions.ProjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Project findById(Integer id) {
        return projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    @Override
    public Collection<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project add(Project entity) {
        projectRepository.save(entity);
        for (User u : entity.getUsers()) {
            Set<Project> projects = u.getProjects();
            projects.add(entity);
            u.setProjects(projects);
            userRepository.save(u);
        }
        return projectRepository.save(entity);
    }

    @Override
    public void update(Project entity) {
        projectRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        projectRepository.deleteById(id);
    }

}
