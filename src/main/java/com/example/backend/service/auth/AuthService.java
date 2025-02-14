package com.example.backend.service.auth;

import com.example.backend.controller.auth.dto.LoginRequest;
import com.example.backend.controller.auth.dto.LoginResponse;
import com.example.backend.controller.auth.dto.UserInfo;
import com.example.backend.domain.jwt.Jwt;
import com.example.backend.domain.jwt.JwtProvider;
import com.example.backend.domain.user.SocialType;
import com.example.backend.domain.user.User;
import com.example.backend.domain.user.UserRepository;
import com.example.backend.service.client.LoginClients;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final LoginClients loginClients;
    private final JwtProvider jwtProvider;

    public LoginResponse login(final String socialType, final LoginRequest request) {
        final SocialType type = SocialType.from(socialType);

        final UserInfo userInfo = loginClients.findUserInfo(type, request.authorizationCode());

        final User user = userRepository.findBySocialIdAndSocialType(userInfo.socialId(), type)
                .orElseGet(() -> initUser(userInfo, type, userInfo.socialId()));
        final Jwt accessToken = jwtProvider.createToken(user.getId());
        return LoginResponse.from(user, accessToken);
    }

    private User initUser(final UserInfo userInfo, final SocialType type, final Long socialId) {
        final User user = User.of(socialId, type, userInfo.nickname());
        return userRepository.save(user);
    }
}
