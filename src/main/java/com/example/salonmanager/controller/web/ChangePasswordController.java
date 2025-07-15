package com.example.salonmanager.controller.web;

import com.example.salonmanager.exception.CustomerException;
import com.example.salonmanager.request.ChangePasswordRequest;
import com.example.salonmanager.request.OTPRequest;
import com.example.salonmanager.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/password")
@RequiredArgsConstructor
public class ChangePasswordController {

    private final AuthenticationService authenticationService;

    public ChangePasswordController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/request-otp")
    public ResponseEntity<String> requestChangePassword(@RequestBody OTPRequest request) throws CustomerException {
        String result = authenticationService.requestChangePassword(request.getEmail());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/change")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest request) throws CustomerException {
        String result = authenticationService.changePassword(
                    request.getEmail(),
                    request.getCode(),
                    request.getNewPassword()
        );
        return ResponseEntity.ok(result);
    }
}
