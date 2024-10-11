package com.app.seek.domain.service;

import com.app.seek.domain.dto.security.AuthenticationRequest;
import com.app.seek.domain.dto.security.AuthenticationResponse;
import com.app.seek.domain.dto.security.RegisterRequest;
import com.app.seek.persistence.crud.UserCrudRepository;
import com.app.seek.persistence.entity.Role;
import com.app.seek.persistence.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private UserCrudRepository repository;

    @Autowired
    private JwtService service;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = repository.findByUsername(request.getUsername()).orElseThrow();
        String token = service.getToken(userDetails);
        return AuthenticationResponse.builder()
                .jwt(token)
                .build();
    }

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .password(passwordEncoder.encode( request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        return AuthenticationResponse.builder()
                .jwt(service.getToken(user))
                .build();

    }
}
