package com.api.usersapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;
import com.api.usersapp.model.Authority;
import com.api.usersapp.model.AuthorityName;
import com.api.usersapp.model.User;
import com.api.usersapp.repository.AuthorityRepository;
import com.api.usersapp.repository.UserRepository;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public void run(String... args) throws Exception {
        
        if (this.authorityRepository.count() == 0) {
            this.authorityRepository.save(new Authority(AuthorityName.ADMIN));
            this.authorityRepository.save(new Authority(AuthorityName.READ));
            this.authorityRepository.save(new Authority(AuthorityName.WRITE));
        }

        if (this.userRepository.count() == 0) {

            var encoders = PasswordEncoderFactories.createDelegatingPasswordEncoder();
          
            this.userRepository
            .save(
            new User("marcoof",encoders.encode("password"),
             List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get()))
             );
        }


    }


}