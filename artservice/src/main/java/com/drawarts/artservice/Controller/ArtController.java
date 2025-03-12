package com.drawarts.artservice.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.drawarts.artservice.Entity.Art;
import com.drawarts.artservice.Service.ArtService;

@RestController
@RequestMapping("/arts")
public class ArtController {

    @Autowired
    private ArtService artService;

    @PostMapping
    public ResponseEntity<?> addArt(@RequestBody Art art) {
        Art createdArt = artService.addArt(art);
        return ResponseEntity.ok(createdArt);
    }

    @GetMapping
    public ResponseEntity<List<Art>> getAllArts() {
        List<Art> arts = artService.getAllArts();
        return ResponseEntity.ok(arts);
    }

    @GetMapping("/user/{artist}")
    public ResponseEntity<List<Art>> getArtsByArtist(@PathVariable String artist) {
        List<Art> arts = artService.getArtsByArtist(artist);
        return ResponseEntity.ok(arts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getArtById(@PathVariable Long id) {
        Art art = artService.getArtById(id);
        if (art == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(art);
    }
}
