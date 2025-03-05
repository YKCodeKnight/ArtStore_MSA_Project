package com.example.artstore.Controller;

import com.example.artstore.Entity.Cart;
import com.example.artstore.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/savecart")
    public Cart addToCart(@RequestBody Cart cart) {
        return cartService.addToCart(cart);  // Add art to cart
    }

    @GetMapping("/")
    public List<Cart> getCartItems(@RequestParam Long userId) {
        return cartService.getCartItems(userId);  // Get cart items by userId
    }

    @DeleteMapping("/deleteCart/{id}")
    public void removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);  // Remove item from cart
    }
}

