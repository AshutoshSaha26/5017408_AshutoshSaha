package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        // Validate the username and password (this should be done against a user service or database)
        if ("user".equals(username) && "password".equals(password)) {
            String token = jwtUtil.generateToken(username);
            return ResponseEntity.ok().header("Authorization", "Bearer " + token).body("Login successful");
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
