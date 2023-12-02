package com.worldwork.beworldwork.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JwtResponse {
    private String token;
    private String refreshToken;
}
