package com.challenge.backend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Classes
import com.challenge.backend.model.entities.OrderVivo;

@Repository
public interface OrdersRepo extends JpaRepository<OrderVivo, UUID> {
    
}
