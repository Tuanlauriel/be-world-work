package com.worldwork.beworldwork.controllers;

import com.worldwork.beworldwork.dto.MessageResponse;
import com.worldwork.beworldwork.dto.UserCreateRequest;
import com.worldwork.beworldwork.dto.UserDTO;
import com.worldwork.beworldwork.entities.Role;
import com.worldwork.beworldwork.entities.User;
import com.worldwork.beworldwork.services.AuthService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final AuthService authService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = authService.getAllUsers();
        List<UserDTO> userResponse = users.stream()
                        .map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody UserCreateRequest userRequest) {
        if (StringUtils.hasLength(userRequest.getEmail()) && userRequest.getPassword().length() >= 6) {
            if (authService.existsEmail(userRequest.getEmail())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse("Email already in use."));
            }
            User user = authService.createAccount(userRequest, Role.USER);
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getUser_id())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .role(user.getRole())
                    .address(user.getAddress())
                    .phone(user.getPhone())
                    .build();
            return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Invalid email or password"));
    }

    @PostMapping("/create-employers")
    public ResponseEntity<?> createEmployers(@RequestBody UserCreateRequest userRequest) {
        if (StringUtils.hasLength(userRequest.getEmail()) && userRequest.getPassword().length() >= 6) {
            if (authService.existsEmail(userRequest.getEmail())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse("Email already in use."));
            }
            User user = authService.createAccount(userRequest, Role.EMPLOYERS);
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getUser_id())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .role(user.getRole())
                    .address(user.getAddress())
                    .phone(user.getPhone())
                    .build();
            return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Invalid email or password"));
    }
}
