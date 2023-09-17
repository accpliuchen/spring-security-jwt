package com.javaguide.springsecurityjwtguide.security.controller;

import com.javaguide.springsecurityjwtguide.security.common.constants.SecurityConstants;
import com.javaguide.springsecurityjwtguide.security.dto.LoginRequest;
import com.javaguide.springsecurityjwtguide.security.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "Authentication")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @ApiOperation("Login")
    public ResponseEntity<Void> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.createToken(loginRequest);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(SecurityConstants.TOKEN_HEADER, token);
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/logout")
    @ApiOperation("Logout")
    public ResponseEntity<Void> logout() {
        authService.removeToken();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
