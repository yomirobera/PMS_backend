package com.example.pms.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ToDoNotFoundException extends RuntimeException {
    public ToDoNotFoundException(int id) {
        super(String.format("ToDo with %d not found",id));
    }
}
