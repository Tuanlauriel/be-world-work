package com.worldwork.beworldwork.dto;

import com.worldwork.beworldwork.entities.Role;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserCreateRequest {
    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Role role;
}
