package com.api.usersapp.security.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;
import com.api.usersapp.security.auth.RegisterRequest;
import com.api.usersapp.security.model.AuthorityName;
import com.api.usersapp.security.model.User;
import com.api.usersapp.security.repository.AuthorityRepository;
import com.api.usersapp.security.repository.UserRepository;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(RegisterRequest request) {
        var encoders = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User user = new User(request.username,
                encoders.encode(request.password),
                List.of(this.authorityRepository.findByName(AuthorityName.READ).get()));

        return userRepository.save(user);
    }





}
