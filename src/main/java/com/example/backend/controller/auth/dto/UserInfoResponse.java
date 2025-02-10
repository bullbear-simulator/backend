package com.example.backend.controller.auth.dto;

import com.example.backend.domain.user.SocialType;
import com.example.backend.domain.user.User;

public record UserInfoResponse(
        String name,
        Long socialId,
        SocialType socialType
) {
    public static UserInfoResponse from(final User user) {
        return new UserInfoResponse(user.getName(), user.getSocialId(), user.getSocialType());
    }
}
