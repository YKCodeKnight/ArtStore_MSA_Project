package com.drawarts.authservice.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.drawarts.authservice.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
