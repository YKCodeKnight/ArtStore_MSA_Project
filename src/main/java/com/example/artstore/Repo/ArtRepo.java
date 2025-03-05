package com.example.artstore.Repo;

import com.example.artstore.Entity.Art;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtRepo extends JpaRepository<Art, Long> {
}

