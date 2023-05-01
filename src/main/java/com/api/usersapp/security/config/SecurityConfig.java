package com.api.usersapp.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                    .httpBasic()
                    .and()
                    .authorizeHttpRequests()
                    //.anyRequest().permitAll()
                    //.anyRequest().denyAll()
                    //.anyRequest().authenticated()
                    //.requestMatchers("/user").permitAll()
                    //.requestMatchers("/admin").hasAuthority("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/newuser").hasAuthority("ADMIN")
                    .and().csrf().disable()
                    .build();
    }
}
