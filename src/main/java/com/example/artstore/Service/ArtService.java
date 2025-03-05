package com.example.artstore.Service;

import com.example.artstore.Entity.Art;
import com.example.artstore.Repo.ArtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtService {
    @Autowired
    private ArtRepo artRepo;

    public List<Art> getAllArts() {
        return artRepo.findAll();  // Fetch all art pieces
    }

    public Art saveArt(Art art) {
        return artRepo.save(art);  // Save new art piece
    }

    public Optional<Art> getArtById(Long id) {
        return artRepo.findById(id);  // Get art piece by ID
    }

    public void deleteArt(Long id) {
        artRepo.deleteById(id);  // Delete art piece by ID
    }
}

