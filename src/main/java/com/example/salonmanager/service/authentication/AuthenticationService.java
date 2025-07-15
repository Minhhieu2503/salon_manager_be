package com.example.salonmanager.service.authentication;

import com.example.salonmanager.exception.RefreshTokenException;
import com.example.salonmanager.request.LoginRequest;
import com.example.salonmanager.request.RefreshTokenRequest;
import com.example.salonmanager.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(LoginRequest request);

    AuthenticationResponse refreshToken(RefreshTokenRequest request) throws RefreshTokenException;
}
