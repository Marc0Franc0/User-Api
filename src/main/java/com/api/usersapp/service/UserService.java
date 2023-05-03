package com.api.usersapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.usersapp.security.auth.RegisterRequest;
import com.api.usersapp.security.model.User;
@Service
public interface UserService {

    List<User> getAll();

    Optional<User> getById(Long id);

    User updateById(Long id,RegisterRequest request);

    Optional<User> deleteById(Long id);
    
}
