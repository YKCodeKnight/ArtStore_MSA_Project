package com.example.artstore.Controller;

import com.example.artstore.Entity.Art;
import com.example.artstore.Service.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/art")
public class ArtController {
    @Autowired
    private ArtService artService;

    @GetMapping("/new_arrivals")
    public List<Art> getNewArrivals() {
        return artService.getAllArts();  // Fetch all art pieces
    }

    @PostMapping("/save")
    public Art saveArt(@RequestBody Art art) {
        return artService.saveArt(art);  // Save new art piece
    }

    @GetMapping("/{id}")
    public Optional<Art> getArtById(@PathVariable Long id) {
        return artService.getArtById(id);  // Get art piece by ID
    }

    @DeleteMapping("/deleteArt/{id}")
    public void deleteArt(@PathVariable Long id) {
        artService.deleteArt(id);  // Delete art piece by ID
    }
}

