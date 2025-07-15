package com.example.salonmanager.controller;

import com.example.salonmanager.exception.LoginException;
import com.example.salonmanager.exception.RefreshTokenException;
import com.example.salonmanager.request.LoginRequest;
import com.example.salonmanager.request.RefreshTokenRequest;
import com.example.salonmanager.response.AuthenticationResponse;
import com.example.salonmanager.service.authentication.AuthenticationService;
//import com.example.salonmanager.service.vnpay.VnPayService;
import com.example.salonmanager.utils.CookieUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/web")
@CrossOrigin
@RequiredArgsConstructor
public class LoginController {
    private final AuthenticationService authenticationService;
    private final CookieUtil cookieUtil;

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginRequest userLoginRequest, HttpServletResponse response)  {
        AuthenticationResponse authResponse = authenticationService.authenticate(userLoginRequest);

        cookieUtil.generatorTokenCookie(response, authResponse);
        return ResponseEntity.ok(authResponse);
    }

}