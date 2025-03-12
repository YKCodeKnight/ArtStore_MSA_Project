package com.drawarts.cartservice.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Identify the owner of the cart item (could be username or user id)
    private String username;
    // ID of the art piece added to the cart
    private Long artId;

    public CartItem() {}

    public CartItem(String username, Long artId) {
        this.username = username;
        this.artId = artId;
    }

    // Getters and setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public Long getArtId() { return artId; }
    public void setArtId(Long artId) { this.artId = artId; }
}
