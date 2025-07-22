package com.example.salonmanager.controller.web;

import com.example.salonmanager.request.LoginRequest;
import com.example.salonmanager.response.AuthenticationResponse;
import com.example.salonmanager.service.authentication.AuthenticationService;
//import com.example.salonmanager.service.vnpay.VnPayService;
import com.example.salonmanager.utils.CookieUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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