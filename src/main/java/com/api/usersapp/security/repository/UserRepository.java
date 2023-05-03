package com.api.usersapp.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.usersapp.security.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    //Retorna user a traves del username
    Optional<User>findByUsername(String username);
}
