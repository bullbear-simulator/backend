package com.example.backend.controller.auth.dto;

public record KakaoAccount(
        Profile profile
) {
    public record Profile(
            String nickname
    ){
    }
}
