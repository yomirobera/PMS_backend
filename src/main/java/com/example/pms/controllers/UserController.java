package com.example.pms.controllers;

import com.example.pms.services.user.UserService;

public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
