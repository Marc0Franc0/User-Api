package com.api.usersapp.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.usersapp.security.repository.UserRepository;
import com.api.usersapp.security.utils.SecurityUser;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Obtención del user a traves del método del repositorio que permite buscar por
        // medio de su username
        // En el caso de existir el mismo se utiliza para retornar una instancia de
        // SecurityUser a partir del mismo
        // En el caso de no existir de lanza una excepción de tipo Username not found
        var optUser = userRepository.findByUsername(username);
        if (optUser.isPresent()) {

            return new SecurityUser(optUser.get());
        }

        throw new UsernameNotFoundException("User not found");
    }

}
