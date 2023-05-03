package com.api.usersapp.security.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;
import com.api.usersapp.security.model.Authority;
import com.api.usersapp.security.model.AuthorityName;
import com.api.usersapp.security.model.User;
import com.api.usersapp.security.repository.AuthorityRepository;
import com.api.usersapp.security.repository.UserRepository;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    //El username y password del admin se establece a traves de las variables de entorno
   @Value("${data.user.admin}")
    public String userAdmin;
    @Value("${data.password.admin}")
    public String passwordAdmin;
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
            new User(userAdmin,encoders.encode(passwordAdmin),
             List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get()))
             );
        } 


    }


}