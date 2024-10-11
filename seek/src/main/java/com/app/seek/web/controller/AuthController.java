package com.app.seek.web.controller;

import com.app.seek.domain.dto.security.AuthenticationRequest;
import com.app.seek.domain.dto.security.AuthenticationResponse;
import com.app.seek.domain.dto.security.RegisterRequest;
import com.app.seek.domain.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public  ResponseEntity<AuthenticationResponse>  register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok( authService.register(request));
    }
}
