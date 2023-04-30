package com.api.usersapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.usersapp.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    //Retorna user a traves del username
    Optional<User>findByUsername(String username);
}
