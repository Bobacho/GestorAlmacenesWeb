package com.example.gestoralmacenes.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.data.auditing.AuditingHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(service.login(request));
    }
    @PostMapping(value = "register")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping(value = "validate_token")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Boolean> validate(@RequestBody ValidateRequest token)
    {
        return ResponseEntity.ok(service.validateToken(token));
    }
}
