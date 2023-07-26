package com.challenge.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Classes
import com.challenge.backend.model.entities.Item;

@Repository
public interface ItemsRepo extends JpaRepository<Item, Integer> {
    
}
