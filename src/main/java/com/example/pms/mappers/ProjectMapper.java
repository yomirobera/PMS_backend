package com.example.pms.mappers;

import com.example.pms.models.Chat;
import com.example.pms.models.Project;
import com.example.pms.models.User;
import com.example.pms.models.dto.project.ProjectDTO;

import com.example.pms.models.dto.project.ProjectPostDTO;
import com.example.pms.models.dto.project.ProjectUpdateDTO;
import com.example.pms.repositories.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ProjectMapper {
    @Autowired
    UserRepository userRepository;

    @Mapping(target = "users", source = "users", qualifiedByName = "usersToIds")
    public abstract ProjectDTO projectToProjectDTO(Project project);
    public abstract Collection<ProjectDTO> projectToProjectDTO(Collection<Project> users);

    public abstract Project projectUpdateDtoToProject(ProjectUpdateDTO projectDTO);

    @Mapping(target = "users", source = "users", qualifiedByName = "idsToUsers")
    public abstract Project projectPostDtoToProject(ProjectPostDTO projectDto);

    @Named("usersToIds")
    Set<String> map(Set<User> source) {
        if (source == null) return null;
        return source.stream().map(p -> p.getId()
        ).collect(Collectors.toSet());
    }
    @Named("idsToUsers")
    Set<User> mapToUser(Set<String> source) {
        if (source == null) return null;
        return source.stream().map(id -> userRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid id: " + id)))
                .collect(Collectors.toSet());
    }

}
