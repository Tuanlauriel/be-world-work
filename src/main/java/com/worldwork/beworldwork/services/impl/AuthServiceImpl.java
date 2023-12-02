package com.worldwork.beworldwork.services.impl;

import com.worldwork.beworldwork.dto.JwtResponse;
import com.worldwork.beworldwork.dto.LoginRequest;
import com.worldwork.beworldwork.dto.RefreshTokenDTO;
import com.worldwork.beworldwork.dto.UserCreateRequest;
import com.worldwork.beworldwork.entities.Role;
import com.worldwork.beworldwork.entities.User;
import com.worldwork.beworldwork.repositories.UserRepository;
import com.worldwork.beworldwork.services.AuthService;
import com.worldwork.beworldwork.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public User createAccount(UserCreateRequest userRequest, Role role) {
        User user = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .role(role)
                .build();
        return userRepository.save(user);
    }

    @Override
    public boolean existsEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public JwtResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        var user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        var jwtRefresh = jwtService.generateRefreshToken(new HashMap<>(), user);

        return JwtResponse.builder()
                .token(jwt)
                .refreshToken(jwtRefresh)
                .build();
    }

    @Override
    public JwtResponse refreshToken(RefreshTokenDTO refreshToken) {
        String userEmail = jwtService.extractUsername(refreshToken.token());
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        if (jwtService.isTokenValid(refreshToken.token(), user)) {
            var jwt = jwtService.generateToken(user);
            return JwtResponse.builder()
                    .token(jwt)
                    .refreshToken(refreshToken.token())
                    .build();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
