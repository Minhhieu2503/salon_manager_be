package com.example.salonmanager.service.authentication;

import com.example.salonmanager.exception.CustomerException;
import com.example.salonmanager.exception.RefreshTokenException;
import com.example.salonmanager.exception.RegisterException;
import com.example.salonmanager.request.LoginRequest;
import com.example.salonmanager.request.RefreshTokenRequest;
import com.example.salonmanager.request.RegisterRequest;
import com.example.salonmanager.response.AuthenticationResponse;

public interface AuthenticationService {
    String registerUser(RegisterRequest request) throws RegisterException;

    AuthenticationResponse authenticate(LoginRequest request) ;

    AuthenticationResponse refreshToken(RefreshTokenRequest request) throws RefreshTokenException;

    String requestChangePassword(String email) throws CustomerException;

    String changePassword(String email, String code, String newPassword) throws CustomerException;

    String verifyEmail(String token);

    String resendVerificationCode(String email);
}
