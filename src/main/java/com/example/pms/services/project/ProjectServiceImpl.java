package com.example.pms.services.project;

import com.example.pms.models.Project;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Override
    public Project findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Project> findAll() {
        return null;
    }

    @Override
    public Project add(Project entity) {
        return null;
    }

    @Override
    public Project update(Project entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }
}
