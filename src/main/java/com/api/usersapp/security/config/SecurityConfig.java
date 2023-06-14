package com.api.usersapp.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //Configuración de acceso a endpoints
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http      
              .httpBasic().and()
               .authorizeHttpRequests()
               .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
               .requestMatchers(HttpMethod.POST,"/auth/register").permitAll()
               .requestMatchers(HttpMethod.PUT,"/api/users/{id}").hasAnyAuthority("ADMIN","WRITE")
               .requestMatchers(HttpMethod.GET,"/api/users/").hasAnyAuthority("READ","ADMIN","WRITE")
               .requestMatchers(HttpMethod.GET,"/api/users/{id}").hasAnyAuthority("READ","ADMIN","WRITE")
               .requestMatchers(HttpMethod.DELETE,"/api/users/{id}").hasAuthority("ADMIN")
               .and() 
               .csrf().disable().build();      
    }
    //Encriptación de contraseñas
   @Bean
   PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }
}
