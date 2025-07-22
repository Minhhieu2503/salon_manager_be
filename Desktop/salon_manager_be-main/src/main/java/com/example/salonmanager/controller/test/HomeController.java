package com.example.salonmanager.controller.test;

import com.example.salonmanager.exception.LoginException;
import com.example.salonmanager.exception.RegisterException;
import com.example.salonmanager.request.LoginRequest;
import com.example.salonmanager.request.RegisterRequest;
import com.example.salonmanager.response.AuthenticationResponse;
import com.example.salonmanager.service.authentication.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
@AllArgsConstructor
public class HomeController {
    private final AuthenticationService authenticationService;
    @GetMapping("/demo")
    public ResponseEntity<String> getText(){

        return ResponseEntity.ok("Hello Word!!!");
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest UserRegisterRequest){
        try{
            String message = authenticationService.registerUser(UserRegisterRequest);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (RegisterException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> authenticate(@RequestBody LoginRequest UserLoginRequest){
//        try{
//            return ResponseEntity.status(HttpStatus.OK).body(authenticationService.authenticate(UserLoginRequest));
//        } catch (LoginException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
}

