package com.example.mall.controllers;

import com.example.mall.DAO.UserDAO;
import com.example.mall.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping
public class UserController {
    private final UserService userService;

    // Создание нового пользователя
    @PostMapping(path = "user/create", consumes = "application/json")
    public String createUser(@RequestBody UserDAO userDAO) {
        return userService.createUser(userDAO);
    }

}
