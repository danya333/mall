package com.example.mall.controllers;

import com.example.mall.dao.UserDAO;
import com.example.mall.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping
public class UserController {
    private final UserService userService;

    // Создание нового пользователя
    @PostMapping(path = "user/create", consumes = "application/json")
    public ResponseEntity<Void> createUser(@RequestBody UserDAO userDAO) {
        userService.createUser(userDAO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
