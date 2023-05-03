package com.api.usersapp.security.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import com.api.usersapp.security.model.Authority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority{

    @Autowired
     Authority authority;

    //Retorona el valor del enum authorityame;
    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }
    
}
