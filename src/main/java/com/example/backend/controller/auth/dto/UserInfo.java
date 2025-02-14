package com.example.backend.controller.auth.dto;

import com.example.backend.domain.user.SocialType;

public record UserInfo(
        Long socialId,
        SocialType socialType,
        String nickname
) {
}
