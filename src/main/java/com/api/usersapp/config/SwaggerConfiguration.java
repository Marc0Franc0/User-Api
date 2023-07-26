package com.api.usersapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI configDoc(){
        return new OpenAPI()
                .info(new Info()
                        .title("User-Api")
                        .version("1.0.1")
                        .description("Este proyecto demuestra la implementación de seguridad usando \n" +
                                "Spring Boot 3.0 y autenticación básica."));
    }
}

