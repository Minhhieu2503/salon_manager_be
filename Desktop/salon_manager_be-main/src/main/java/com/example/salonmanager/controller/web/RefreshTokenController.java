package com.example.salonmanager.controller.web;

import com.example.salonmanager.exception.RefreshTokenException;
import com.example.salonmanager.request.RefreshTokenRequest;
import com.example.salonmanager.response.AuthenticationResponse;
import com.example.salonmanager.service.authentication.AuthenticationService;
import com.example.salonmanager.utils.CookieUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web")
@CrossOrigin
@RequiredArgsConstructor
public class RefreshTokenController {
    private final AuthenticationService authenticationService;
    private final CookieUtil cookieUtil;

    @GetMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(HttpServletRequest servletRequest, HttpServletResponse response) throws RefreshTokenException {
        String refreshToken = extractRefreshTokenFromCookies(servletRequest.getCookies());

        if (refreshToken == null || refreshToken.isEmpty()) {
            throw new RefreshTokenException("Refresh token hết hạn hoặc rỗng");
        }

        var refreshTokenRequest = RefreshTokenRequest.builder()
                .refreshToken(refreshToken)
                .build();

        AuthenticationResponse authenticationResponse = authenticationService.refreshToken(refreshTokenRequest);
        cookieUtil.saveAccessTokenCookie(response, authenticationResponse);
        return ResponseEntity.ok(authenticationResponse);
    }

    private String extractRefreshTokenFromCookies(Cookie[] cookies) {
        if (cookies == null) return null;

        for (Cookie cookie : cookies) {
            if ("refreshToken".equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }

}
