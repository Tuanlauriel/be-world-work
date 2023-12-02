package com.worldwork.beworldwork.dto;

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
}
