package com.example.artstore.Service;

import com.example.artstore.Entity.Cart;
import com.example.artstore.Repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ArtService artService;

    public Cart addToCart(Cart cart) {
        if (artService.getArtById(cart.getArtId()).isPresent()) {
            return cartRepo.save(cart);  // Add to cart
        }
        throw new RuntimeException("Art not found");  // Art not found in catalog
    }

    public List<Cart> getCartItems(Long userId) {
        return cartRepo.findByUserId(userId);  // Get all cart items for a specific user
    }

    public void removeFromCart(Long id) {
        cartRepo.deleteById(id);  // Remove item from cart
    }
}

