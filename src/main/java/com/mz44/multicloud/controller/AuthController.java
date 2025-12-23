package com.mz44.multicloud.controller;

import com.mz44.multicloud.model.CloudAccount;
import com.mz44.multicloud.repository.CloudAccountRepository;
import com.mz44.multicloud.util.EncryptionUtil;
import com.mz44.multicloud.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final CloudAccountRepository repository;
    private final EncryptionUtil encryptionUtil;
    private final JwtUtil jwtUtil;

    public AuthController(CloudAccountRepository repository, EncryptionUtil encryptionUtil, JwtUtil jwtUtil) {
        this.repository = repository;
        this.encryptionUtil = encryptionUtil;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        String provider = body.getOrDefault("provider", "generic");
        if (username == null || password == null) return ResponseEntity.badRequest().body("username and password required");
        if (repository.findByUsername(username).isPresent()) return ResponseEntity.badRequest().body("user exists");
        CloudAccount account = new CloudAccount(username, encryptionUtil.encode(password), provider);
        repository.save(account);
        return ResponseEntity.ok(Map.of("token", jwtUtil.generateToken(username)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        if (username == null || password == null) return ResponseEntity.badRequest().body("username and password required");
        return repository.findByUsername(username)
                .map(acc -> {
                    if (encryptionUtil.matches(password, acc.getPassword())) {
                        return ResponseEntity.ok(Map.of("token", jwtUtil.generateToken(username)));
                    } else {
                        return ResponseEntity.status(401).body("invalid credentials");
                    }
                })
                .orElse(ResponseEntity.status(401).body("invalid credentials"));
    }
}
