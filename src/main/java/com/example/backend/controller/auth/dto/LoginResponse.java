package com.example.backend.controller.auth.dto;

import com.example.backend.domain.jwt.Jwt;
import com.example.backend.domain.user.User;

public record LoginResponse(
        Long userId,
        Jwt accessToken
) {
    public static LoginResponse from(final User user, final Jwt accessToken) {
        return new LoginResponse(user.getId(), accessToken);
    }
}
