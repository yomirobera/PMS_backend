package com.example.pms.services.todo;

import com.example.pms.models.ToDo;
import com.example.pms.services.CrudService;
import org.springframework.stereotype.Service;


public interface ToDoService extends CrudService<ToDo,Integer> {
}
