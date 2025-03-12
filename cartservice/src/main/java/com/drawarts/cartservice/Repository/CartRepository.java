package com.drawarts.cartservice.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.drawarts.cartservice.Entity.CartItem;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUsername(String username);
}
