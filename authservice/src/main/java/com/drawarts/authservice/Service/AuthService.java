package com.drawarts.authservice.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.drawarts.authservice.Entity.User;
import com.drawarts.authservice.Repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User signup(User user) {
        if(userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if(user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }
        return user;
    }
}
