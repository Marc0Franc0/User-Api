package com.api.usersapp.service;

import org.springframework.stereotype.Service;

import com.api.usersapp.model.User;

@Service
public interface UserService {
    public User createUser(String username,String password);
}
