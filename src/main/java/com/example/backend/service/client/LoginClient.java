package com.example.backend.service.client;

import com.example.backend.controller.auth.dto.UserInfo;
import com.example.backend.domain.user.SocialType;

public interface LoginClient {

    String requestToken(final String authCode);

    UserInfo findUserInfo(final String accessToken);

    SocialType getSocialType();
}
