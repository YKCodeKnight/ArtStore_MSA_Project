package com.example.artstore.Service;

import com.example.artstore.Entity.User;
import com.example.artstore.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepo userRepo;

    public User registerUser(User user) {
        return userRepo.save(user);  // Register new user
    }

    public Optional<User> authenticateUser(String username, String password) {
        return userRepo.findByUsername(username).filter(user -> user.getPassword().equals(password));  // Authenticate user
    }
}

