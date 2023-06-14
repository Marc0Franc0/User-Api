package com.api.usersapp.security.utils;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.api.usersapp.security.model.User;

import lombok.AllArgsConstructor;

//Clase que implementa UserDetails de Spring
@AllArgsConstructor
public class SecurityUser implements UserDetails{

    @Autowired
     User user;

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
       return user.getUsername();
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return user.getPassword();
    }


    //Retorna el valor de SecurityAuthorities obtenido del listado de authorities de la entidad User
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities().stream().map(SecurityAuthority::new).toList();
    }


 
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
