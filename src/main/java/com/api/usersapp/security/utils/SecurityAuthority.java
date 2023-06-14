package com.api.usersapp.security.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import com.api.usersapp.security.model.Authority;

import lombok.AllArgsConstructor;
//Clase que implementa GrantedAuthority de Spring que se utiliza para las autoridades
@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority{

    @Autowired
     Authority authority;

    //Retorona el valor del enum authorityName;
    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }
    
}
