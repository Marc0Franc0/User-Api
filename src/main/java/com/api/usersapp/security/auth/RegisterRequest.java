package com.api.usersapp.security.auth;

import lombok.Data;

@Data
public class RegisterRequest {
    public String username;
    public String password;
}
