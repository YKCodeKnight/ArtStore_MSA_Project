package com.drawarts.artservice.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.drawarts.artservice.Entity.Art;

public interface ArtRepository extends JpaRepository<Art, Long> {
    List<Art> findByArtist(String artist);
}
