package com.api.usersapp.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.usersapp.security.auth.RegisterRequest;
import com.api.usersapp.security.model.User;
import com.api.usersapp.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class MainController {

    @Autowired
    UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users =userService.getAll();
        if(users.size()!=0){
            return ResponseEntity.status(HttpStatus.OK).body(users);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(users);
        }  
     
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        Optional<User>user = userService.getById(id);
        if(user.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(user.get());
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user.get());
        }
    
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody RegisterRequest request) {
        User user = userService.updateById(id,request);
        if(user!=null){
            return ResponseEntity.status(HttpStatus.OK).body("User modified");
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        Optional<User> user = userService.deleteById(id);
        if(user.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body("User deleted");
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User not found");
        }
    }
}

