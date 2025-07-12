package com.example.salonmanager.service.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("${jwt.expiration_access_token}")
    private long accessTokenExpiration;

    public String generateToken(String username) {
        // Basic implementation for commit 3
        return "jwt_token_" + username;
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("jwt_token_");
    }
}