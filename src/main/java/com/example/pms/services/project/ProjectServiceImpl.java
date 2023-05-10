package com.example.pms.services.project;

import com.example.pms.models.Project;
import com.example.pms.repositories.ProjectRepository;
import com.example.pms.utils.exceptions.ProjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
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
