package com.example.backend.infra.kakao;

import com.example.backend.controller.auth.dto.UserInfo;
import com.example.backend.domain.user.SocialType;
import com.example.backend.service.client.LoginClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KakaoLoginClient implements LoginClient {

    private final KakaoClient kakaoClient;

    @Override
    public String requestToken(final String authCode) {
        return kakaoClient.request(authCode);
    }

    @Override
    public UserInfo findUserInfo(final String accessToken) {
        return kakaoClient.getUserInfo(accessToken);
    }

    @Override
    public SocialType getSocialType() {
        return SocialType.KAKAO;
    }
}
