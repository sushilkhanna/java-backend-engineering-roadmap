package com.clinic.docauthentication.controller;

import com.clinic.docauthentication.dto.LoginRequest;
import com.clinic.docauthentication.dto.SignupRequest;
import com.clinic.docauthentication.model.User;
import com.clinic.docauthentication.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String,String>> signup(@RequestBody SignupRequest request) {
        authService.signup(request.getName(), request.getEmail(), request.getPassword(), request.getRole());
        return ResponseEntity.ok(Map.of("message","Successfully Registered"));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        String token = authService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(Map.of("token", token));
    }
}
