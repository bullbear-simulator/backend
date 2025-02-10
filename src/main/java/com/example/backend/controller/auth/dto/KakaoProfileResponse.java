package com.example.backend.controller.auth.dto;

import com.example.backend.domain.user.SocialType;

public record KakaoProfileResponse(
        Long id,
        KakaoAccount kakao_account
) {
    public UserInfo toUserInfo() {
        return new UserInfo(id, SocialType.KAKAO, getName());
    }

    public String getName() {
        return kakao_account.profile().nickname();
    }
}
