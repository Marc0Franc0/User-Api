package com.api.usersapp.security.service;

import org.springframework.stereotype.Service;
import com.api.usersapp.security.auth.RegisterRequest;
import com.api.usersapp.security.model.User;

@Service
public interface UserSecurityService {
    public User createUser(RegisterRequest request);

}
