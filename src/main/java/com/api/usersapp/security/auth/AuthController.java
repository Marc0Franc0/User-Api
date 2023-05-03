package com.api.usersapp.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.usersapp.security.model.User;
import com.api.usersapp.security.service.SecurityUserDetailsService;
import com.api.usersapp.security.service.UserSecurityService;

@RestController
@RequestMapping(value = "/auth")    
public class AuthController {

    @Autowired
    UserSecurityService userService;

    @Autowired
    SecurityUserDetailsService userDetailsService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegisterRequest request) {

        return userService.createUser(request);

    }



}