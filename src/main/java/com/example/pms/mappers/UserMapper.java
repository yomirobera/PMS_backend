package com.example.pms.mappers;

import com.example.pms.models.Chat;
import com.example.pms.models.Project;
import com.example.pms.models.ToDo;
import com.example.pms.models.User;
import com.example.pms.models.dto.user.UserDTO;
import com.example.pms.models.dto.user.UserPostDTO;
import com.example.pms.models.dto.user.UserUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Mapping(target = "projects", source = "projects", qualifiedByName = "projectToIds")
    @Mapping(target = "chats", source = "chats", qualifiedByName = "chatToIds")
    @Mapping(target = "toDoList", source = "toDoList", qualifiedByName = "toDoListToIds")
    public abstract UserDTO userToUserDto(User user);
    public abstract Collection<UserDTO> userToUserDto(Collection<User> users);

    public abstract User userUpdateDtoToUser(UserUpdateDTO userDTO);

    public abstract User userPostDtoToUser(UserPostDTO userDto);

    @Named("projectToIds")
    Set<Integer> mapProject(Set<Project> source) {
        if (source == null) return null;
        return source.stream().map(p -> p.getId()
        ).collect(Collectors.toSet());
    }
    @Named("chatToIds")
    Set<Integer> mapChat(Set<Chat> source) {
        if (source == null) return null;
        return source.stream().map(p -> p.getId()
        ).collect(Collectors.toSet());
    }
    @Named("toDoListToIds")
    Set<Integer> mapToDoListToIds(Set<ToDo> source) {
        if (source == null) return null;
        return source.stream().map(p -> p.getId()
        ).collect(Collectors.toSet());
    }
}
