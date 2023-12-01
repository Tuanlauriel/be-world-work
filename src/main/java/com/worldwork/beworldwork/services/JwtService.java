package com.worldwork.beworldwork.services;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Objects;

public interface JwtService {
    String extractUsername(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);

    String generateRefreshToken(HashMap<String, Objects> extractClaims, UserDetails userDetails);
}
