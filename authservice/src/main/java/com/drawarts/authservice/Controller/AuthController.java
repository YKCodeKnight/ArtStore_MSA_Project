package com.drawarts.authservice.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.drawarts.authservice.Entity.User;
import com.drawarts.authservice.Service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        try {
            User createdUser = authService.signup(user);
            return ResponseEntity.ok(createdUser);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            User loggedInUser = authService.login(user.getUsername(), user.getPassword());
            return ResponseEntity.ok(loggedInUser);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
