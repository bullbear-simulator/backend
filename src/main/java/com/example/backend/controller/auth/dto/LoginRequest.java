package com.example.backend.controller.auth.dto;

public record LoginRequest (
        String authorizationCode
) {
}
