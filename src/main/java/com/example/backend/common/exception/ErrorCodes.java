package com.example.backend.common.exception;

public enum ErrorCodes {

    // 토큰 관련
    TOKEN_NULL_EXCEPTION("토큰이 비어있으면 안됩니다.", 1000L),

    // 인증 관련
    UNSUPPORTED_OAUTH_PROVIDER("해당 OAuth2 제공자는 지원되지 않습니다.", 2000L),

    BAD_REQUEST("BAD_REQUEST", 9404L),
    BAD_REQUEST_JSON_PARSE_ERROR("[BAD_REQUEST] JSON_PARSE_ERROR - 올바른 JSON 형식이 아님", 9405L),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", 9999L);

    public final String message;
    public final Long code;

    ErrorCodes(String message, Long code) {
        this.message = message;
        this.code = code;
    }
}
