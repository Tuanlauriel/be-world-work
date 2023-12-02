package com.worldwork.beworldwork.services;

import com.worldwork.beworldwork.dto.JwtResponse;
import com.worldwork.beworldwork.dto.LoginRequest;
import com.worldwork.beworldwork.dto.RefreshTokenDTO;
import com.worldwork.beworldwork.dto.UserCreateRequest;
import com.worldwork.beworldwork.entities.User;

import java.util.List;

public interface AuthService {
    User createAccount(UserCreateRequest userRequest);

    boolean existsEmail(String email);

    JwtResponse login(LoginRequest loginRequest);

    JwtResponse refreshToken(RefreshTokenDTO refreshToken);

    List<User> getAllUsers();
}
