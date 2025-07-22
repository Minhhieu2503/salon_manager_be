package com.example.salonmanager.controller.web;

import com.example.salonmanager.entity.Account;
import com.example.salonmanager.repository.AccountRepo;
import com.example.salonmanager.response.AuthenticationResponse;
import com.example.salonmanager.service.jwt.JwtService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class GoogleAuthController {

    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Thay clientId cũ bằng clientId mới nhất
    private static final String GOOGLE_CLIENT_ID = "360830149071-0437j5sa0ObjS0se6ejok1oel4binn.apps.googleusercontent.com";

    @PostMapping("/google")
    public ResponseEntity<?> googleLogin(@RequestBody Map<String, String> body) {
        String idTokenString = body.get("idToken");
        System.out.println("[GOOGLE LOGIN] Nhận idToken từ FE: " + (idTokenString != null ? idTokenString.substring(0, Math.min(20, idTokenString.length())) + "..." : "null"));
        GoogleIdToken.Payload payload = verifyGoogleToken(idTokenString);
        if (payload == null) {
            System.out.println("[GOOGLE LOGIN] Invalid Google token hoặc clientId không đúng!");
            return ResponseEntity.status(401).body("Invalid Google token");
        }

        String email = payload.getEmail();
        String name = (String) payload.get("name");
        String sub = payload.getSubject();

        Optional<Account> optionalAccount = accountRepo.findByEmail(email);
        Account account = optionalAccount.orElseGet(() -> {
            Account acc = new Account();
            acc.setEmail(email);
            acc.setFullName(name);
            acc.setProvider("GOOGLE");
            acc.setProviderId(sub);
            acc.setPassword(passwordEncoder.encode(sub)); // random password
            acc.setUserName(email.split("@")[0]);
            acc.setAvatar("https://i.postimg.cc/pVs3qTMy/image.png");
            acc.setIsBlocked(false);
            // TODO: set role, age, address, phone nếu cần
            return accountRepo.save(acc);
        });

        String jwt = jwtService.generateAccessToken(account);
        return ResponseEntity.ok(AuthenticationResponse.builder()
                .token(jwt)
                .username(account.getUsername())
                .role(account.getRole() != null ? account.getRole().getName() : "USER")
                .build());
    }

    private GoogleIdToken.Payload verifyGoogleToken(String idTokenString) {
        try {
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier
                    .Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance())
                    .setAudience(Collections.singletonList(GOOGLE_CLIENT_ID))
                    .build();

            GoogleIdToken idToken = verifier.verify(idTokenString);
            if (idToken != null) {
                System.out.println("[GOOGLE LOGIN] Token hợp lệ, email: " + idToken.getPayload().getEmail());
                return idToken.getPayload();
            } else {
                System.out.println("[GOOGLE LOGIN] idToken verify trả về null! Có thể sai clientId hoặc token không hợp lệ.");
            }
        } catch (Exception e) {
            System.out.println("[GOOGLE LOGIN] Exception khi verify idToken: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}