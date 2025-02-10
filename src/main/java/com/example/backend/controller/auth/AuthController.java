package com.example.backend.controller.auth;

import com.example.backend.controller.auth.dto.LoginRequest;
import com.example.backend.controller.auth.dto.LoginResponse;
import com.example.backend.service.auth.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/{socialType}")
    public ResponseEntity<String> login(
            @PathVariable final String socialType,
            @RequestBody final LoginRequest loginRequest,
            HttpServletResponse response
    ) {
        final LoginResponse kakaoResponse = authService.login(socialType, loginRequest);
        final String token = kakaoResponse.accessToken().token();

        Cookie cookie = new Cookie("Authorization", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24);

        response.addCookie(cookie);

        return ResponseEntity.status(HttpStatus.OK)
                .body("JWT 토큰이 쿠키에 저장되었습니다.");
    }
}
