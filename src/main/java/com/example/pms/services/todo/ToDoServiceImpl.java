package com.example.pms.services.todo;

import com.example.pms.models.ToDo;
import com.example.pms.repositories.ToDoRepository;
import com.example.pms.utils.exceptions.ToDoNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ToDoServiceImpl implements ToDoService{
    private final ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public ToDo findById(Integer id) {
        return toDoRepository.findById(id).orElseThrow(() -> new ToDoNotFoundException(id));
    }

    @Override
    public Collection<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo add(ToDo entity) {
        return toDoRepository.save(entity);
    }

    @Override
    public void update(ToDo entity) {
        toDoRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        toDoRepository.deleteById(id);
    }
}
