package com.api.usersapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.api.usersapp.model.User;
import com.api.usersapp.service.UserService;

@RestController
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping("/admin")
    public String status() {
        return "Hola Admin";
    }

    @GetMapping("/user")
    public String statuss() {
        return "Hola User";
    }

    @PostMapping("/newuser")
    public User createUser(@RequestParam String username, String password) {

        return userService.createUser(username, password);

    }

}
