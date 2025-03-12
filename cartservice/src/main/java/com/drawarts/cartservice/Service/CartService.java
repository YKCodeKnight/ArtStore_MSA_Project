package com.drawarts.cartservice.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.drawarts.cartservice.Client.ArtFeignClient;
import com.drawarts.cartservice.Entity.CartItem;
import com.drawarts.cartservice.Repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ArtFeignClient artFeignClient;

    public CartItem addCartItem(CartItem cartItem) {
        // Use Feign client to check if the art exists
        if(artFeignClient.getArtById(cartItem.getArtId()) == null) {
            throw new RuntimeException("Art not found with id: " + cartItem.getArtId());
        }
        return cartRepository.save(cartItem);
    }

    public void deleteCartItem(Long id) {
        cartRepository.deleteById(id);
    }

    public List<CartItem> getCartItemsByUsername(String username) {
        return cartRepository.findByUsername(username);
    }
}
