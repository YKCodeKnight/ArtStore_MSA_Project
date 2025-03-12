package com.drawarts.cartservice.Client.dto;

public class ArtDto {
    private Long id;
    private String title;
    private String description;
    private String artist;

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
