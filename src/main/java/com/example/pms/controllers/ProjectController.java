package com.example.pms.controllers;

import com.example.pms.services.project.ProjectService;

public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
}
