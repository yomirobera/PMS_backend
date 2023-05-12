package com.example.pms.mappers;

import com.example.pms.models.ToDo;
import com.example.pms.models.dto.todo.ToDoDTO;
import com.example.pms.models.dto.todo.ToDoPostDTO;
import com.example.pms.models.dto.todo.ToDoUpdateDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class ToDoMapper {
    public abstract ToDoDTO todoToToDoDto(ToDo todo);
    public abstract Collection<ToDoDTO> todoToToDoDto(Collection<ToDo> todos);

    public abstract ToDo todoUpdateDtoToToDo(ToDoUpdateDTO todoDTO);

    public abstract ToDo todoPostDtoToToDo(ToDoPostDTO todoDto);
}
