package com.api.usersapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import com.api.usersapp.model.AuthorityName;
import com.api.usersapp.model.User;
import com.api.usersapp.repository.AuthorityRepository;
import com.api.usersapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(String username, String password) {
        var encoders = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User user = new User(username,
                encoders.encode(password),
                List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get()));

        return userRepository.save(user);
    }

}
