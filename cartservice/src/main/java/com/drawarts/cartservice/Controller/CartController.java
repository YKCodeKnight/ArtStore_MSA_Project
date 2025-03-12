package com.drawarts.cartservice.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.drawarts.cartservice.Entity.CartItem;
import com.drawarts.cartservice.Service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<?> addCartItem(@RequestBody CartItem cartItem) {
        try {
            CartItem createdItem = cartService.addCartItem(cartItem);
            return ResponseEntity.ok(createdItem);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCartItem(@PathVariable Long id) {
        try {
            cartService.deleteCartItem(id);
            return ResponseEntity.ok("Cart item deleted successfully");
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<CartItem>> getCartItemsByUsername(@PathVariable String username) {
        List<CartItem> items = cartService.getCartItemsByUsername(username);
        return ResponseEntity.ok(items);
    }
}
