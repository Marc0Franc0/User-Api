package com.api.usersapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.usersapp.security.auth.RegisterRequest;
import com.api.usersapp.security.model.User;
import com.api.usersapp.security.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        // TODO Auto-generated method stub
       return userRepository.findById(id);
    }

    @Override
    public User updateById(Long id,RegisterRequest request) {
       // var user = userRepository.findById(id);
    User userModified = userRepository.findById(id).get();
    userModified.setUsername(request.getUsername());
    userModified.setPassword(request.getPassword());
    userRepository.save(userModified);
    return userModified;
       
    }

    @Override
    public Optional<User> deleteById(Long id) {
         
          userRepository.deleteById(id);
          return userRepository.findById(id);
    }
    
}
