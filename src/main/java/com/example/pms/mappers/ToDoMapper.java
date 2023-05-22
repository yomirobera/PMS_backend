package com.example.pms.mappers;

import com.example.pms.models.ToDo;
import com.example.pms.models.User;
import com.example.pms.models.dto.todo.ToDoDTO;
import com.example.pms.models.dto.todo.ToDoPostDTO;
import com.example.pms.models.dto.todo.ToDoUpdateDTO;
import com.example.pms.services.user.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class ToDoMapper {
    @Autowired
    UserService userService;
    @Mapping(target = "user", source = "user", qualifiedByName = "userToId")
    public abstract ToDoDTO todoToToDoDto(ToDo todo);
    public abstract Collection<ToDoDTO> todoToToDoDto(Collection<ToDo> todos);

    public abstract ToDo todoUpdateDtoToToDo(ToDoUpdateDTO todoDTO);
    @Mapping(target = "user", source = "user", qualifiedByName = "idToUser")
    public abstract ToDo todoPostDtoToToDo(ToDoPostDTO todoDto);
    @Named("userToId")
    String map(User source) {
        if (source == null) return null;
        return source.getId();
    }
    @Named("idToUser")
    User mapToUser(String id) {
        return userService.findById(id);
    }
}
