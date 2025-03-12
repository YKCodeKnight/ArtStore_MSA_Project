package com.drawarts.artservice.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.drawarts.artservice.Entity.Art;
import com.drawarts.artservice.Repository.ArtRepository;

@Service
public class ArtService {

    @Autowired
    private ArtRepository artRepository;

    public Art addArt(Art art) {
        return artRepository.save(art);
    }

    public List<Art> getAllArts() {
        return artRepository.findAll();
    }

    public List<Art> getArtsByArtist(String artist) {
        return artRepository.findByArtist(artist);
    }

    public Art getArtById(Long id) {
        return artRepository.findById(id).orElse(null);
    }
}
