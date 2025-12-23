package com.mz44.multicloud.controller;

import com.mz44.multicloud.model.CloudAccount;
import com.mz44.multicloud.repository.CloudAccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final CloudAccountRepository repository;

    public AccountController(CloudAccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<CloudAccount>> list() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(@AuthenticationPrincipal CloudAccount account) {
        if (account == null) return ResponseEntity.status(401).build();
        return ResponseEntity.ok(Map.of("username", account.getUsername(), "provider", account.getProvider()));
    }
}
