package com.example.backend.service.client;

import com.example.backend.common.exception.BackEndApplicationException;
import com.example.backend.common.exception.ErrorCodes;
import com.example.backend.controller.auth.dto.UserInfo;
import com.example.backend.domain.user.SocialType;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.http.HttpStatus;

public class LoginClients {

    private final Map<SocialType, LoginClient> clients;

    public LoginClients(final Set<LoginClient> clients) {
        final EnumMap<SocialType, LoginClient> mapping = new EnumMap<>(SocialType.class);
        clients.forEach(client -> mapping.put(client.getSocialType(), client));
        this.clients = mapping;
    }

    public UserInfo findUserInfo(final SocialType socialType, final String code) {
        final LoginClient client = getClient(socialType);
        final String accessToken = client.requestToken(code);
        return client.findUserInfo(accessToken);
    }

    private LoginClient getClient(final SocialType socialType) {
        return Optional.ofNullable(clients.get(socialType))
                .orElseThrow(() -> new BackEndApplicationException(ErrorCodes.UNSUPPORTED_OAUTH_PROVIDER,
                        HttpStatus.BAD_REQUEST));
    }
}
