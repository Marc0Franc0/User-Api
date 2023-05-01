package com.api.usersapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig {
/* 
    @Bean
    public UserDetailsService userDetailsService(){
var user = User
.withUsername("marco")
.password("1234")
.roles("read")
.build();
 return new InMemoryUserDetailsManager(user);
    } */

    @Bean
    public PasswordEncoder passwordEncoder(){
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    } 

}
