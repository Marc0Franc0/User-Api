package com.api.usersapp.security.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    PasswordEncoder passwordEncoder;

    //El username y password del admin se establece a traves de las variables de entorno
   @Value("${data.user.admin}")
    public String userAdmin;
    @Value("${data.password.admin}")
    public String passwordAdmin;

    @Override
    public void run(String... args) throws Exception {
         /*Se almacenan en la base de datos las 3 autoridades que son
     ADMIN,READ Y WRITE en el caso de no existir*/
        if (this.authorityRepository.count() == 0) {
            this.authorityRepository.save(new Authority(AuthorityName.ADMIN));
            this.authorityRepository.save(new Authority(AuthorityName.READ));
            this.authorityRepository.save(new Authority(AuthorityName.WRITE));
        }

        /*Se almacena en la base de datos el usuario admin utilizando los
        datos de aplication.properties en el caso de no existir
         */
       if (this.userRepository.count() == 0) {
        
             this.userRepository
            .save(
            new User(userAdmin,passwordEncoder.encode(passwordAdmin),
             List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get()))
             );
        } 


    }


}