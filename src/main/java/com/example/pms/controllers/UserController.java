package com.example.pms.controllers;

import com.example.pms.mappers.UserMapper;
import com.example.pms.models.User;
import com.example.pms.services.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Operation(summary = "Get all users")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
//            @ApiResponse(responseCode = "400",
//                    description = "Malformed request",
//                    content ={ @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
//            @ApiResponse(responseCode = "404",
//                    description = "Users not found",
//                    content = { @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(userMapper.userToUserDto(userService.findAll()));
    }
}
