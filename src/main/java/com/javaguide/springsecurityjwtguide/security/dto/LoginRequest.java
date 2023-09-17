package com.javaguide.springsecurityjwtguide.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {

    private String username;
    private String password;
    private Boolean rememberMe;
}
