package com.example.artstore.Controller;

import com.example.artstore.Entity.User;
import com.example.artstore.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return authService.registerUser(user);  // Register new user
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        Optional<User> authenticatedUser = authService.authenticateUser(user.getUsername(), user.getPassword());
        if (authenticatedUser.isPresent()) {
            return ResponseEntity.ok("Login successful");  // Successful login
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");  // Invalid login
        }
    }
}

