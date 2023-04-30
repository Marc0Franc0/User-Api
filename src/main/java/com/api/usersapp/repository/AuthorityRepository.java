package com.api.usersapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.usersapp.model.Authority;
import com.api.usersapp.model.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority,Long>{
    //Retorna autoridad a traves del nombre la misma
    Optional<Authority>findByName(AuthorityName name);
}
