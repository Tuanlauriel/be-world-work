package com.worldwork.beworldwork.controllers;

import com.worldwork.beworldwork.dto.LoginRequest;
import com.worldwork.beworldwork.dto.MessageResponse;
import com.worldwork.beworldwork.dto.RefreshTokenDTO;
import com.worldwork.beworldwork.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        if (StringUtils.hasLength(loginRequest.getEmail())) {
            return ResponseEntity.ok(authService.login(loginRequest));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Invalid email or password."));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenDTO refreshTokenDTO) {
        if (StringUtils.hasLength(refreshTokenDTO.token())) {
            return ResponseEntity.ok(authService.refreshToken(refreshTokenDTO));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Invalid token"));
    }

}
