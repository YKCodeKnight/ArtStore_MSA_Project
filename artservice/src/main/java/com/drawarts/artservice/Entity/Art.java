package com.drawarts.artservice.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "arts")
public class Art {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String artist; // This can be the username or user ID

    public Art() {}

    public Art(String title, String description, String artist) {
        this.title = title;
        this.description = description;
        this.artist = artist;
    }

    // Getters and setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }
}
