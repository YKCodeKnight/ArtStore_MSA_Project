package com.example.artstore.Repo;

import com.example.artstore.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    List<Cart> findByUserId(Long userId);  // Fetch cart items by userId
}

