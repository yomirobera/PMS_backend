package com.example.pms.controllers;

import com.example.pms.mappers.ToDoMapper;
import com.example.pms.models.ToDo;
import com.example.pms.models.dto.todo.ToDoPostDTO;
import com.example.pms.models.dto.todo.ToDoUpdateDTO;
import com.example.pms.services.todo.ToDoService;
import com.example.pms.utils.error.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/v1/todos")
public class ToDoController {

    private final ToDoService todoService;
    private final ToDoMapper todoMapper;
    public ToDoController(ToDoService todoService, ToDoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }

    @Operation(summary = "Get all todos")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ToDo.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content ={ @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "ToDos not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(todoMapper.todoToToDoDto(todoService.findAll()));
    }
    @Operation(summary = "Get a todo by id")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ToDo.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "ToDo not found with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable int id) {
        return ResponseEntity.ok(todoMapper.todoToToDoDto(todoService.findById(id)));
    }
    @Operation(summary = "Updates a todo")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "ToDo is successfully updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ToDo.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "ToDo was not found with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody ToDoUpdateDTO todoDTO, @PathVariable int id) {
        // Validates if body is correct
        if (id != todoDTO.getId())
            return ResponseEntity.badRequest().build();

        todoService.update(todoMapper.todoUpdateDtoToToDo(todoDTO));
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Adds new todo")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201",
                    description = "ToDo was successfully added",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ToDo.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "ToDo was not found with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @PostMapping
    public ResponseEntity add(@RequestBody ToDoPostDTO todoDto) {
        ToDo todo = todoService.add(todoMapper.todoPostDtoToToDo(todoDto));
        URI location = URI.create("todos/" + todo.getId());
        return ResponseEntity.created(location).build();
    }
    @Operation(summary = "Deletes an existing todo by id")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "ToDo is successfully deleted",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ToDo.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "ToDo was not found with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
