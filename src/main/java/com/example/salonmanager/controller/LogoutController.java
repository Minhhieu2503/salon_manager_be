package com.example.salonmanager.controller;

import com.example.salonmanager.exception.LogoutException;
import com.example.salonmanager.service.jwt.JwtService;
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
public class LogoutController {
    private final JwtService jwtService;
    private final CookieUtil cookieUtil;

    public LogoutController(JwtService jwtService, CookieUtil cookieUtil) {
        this.jwtService = jwtService;
        this.cookieUtil = cookieUtil;
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) throws LogoutException {
        String refreshToken = getRefreshTokenFromCookies(request);

        if (refreshToken != null) {
            jwtService.revokeRefreshToken(refreshToken);
        } else {
            throw new LogoutException("Refresh token không có");
        }

        cookieUtil.removeCookies(response);
        return ResponseEntity.ok("Đăng xuất thành công");
    }

    private String getRefreshTokenFromCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("refreshToken".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
