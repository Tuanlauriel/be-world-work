package com.worldwork.beworldwork.controllers;

import com.worldwork.beworldwork.dto.*;
import com.worldwork.beworldwork.entities.User;
import com.worldwork.beworldwork.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/{email}/role")
    public ResponseEntity<?> getRoleByEmail(@PathVariable String email) {
        Optional<User> userOptional = authService.getUserByEmail(email);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(new RoleResponse(userOptional.get().getRole()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("User not found."));
    }

}
