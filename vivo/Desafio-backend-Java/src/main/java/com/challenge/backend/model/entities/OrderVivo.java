package com.challenge.backend.model.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.PrePersist;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.PersistenceCreator;

import com.challenge.backend.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orders")
public class OrderVivo {

    // Properties
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private Double totalPrice;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Item> items;

    @PrePersist
    private void PrePersist() {
        UUID uuid = UUID.randomUUID();
        setId(uuid);
    }


    // Constructors
    @PersistenceCreator
    public OrderVivo(Integer userId, Status status, Double totalPrice) {
        setUserId(userId);
        setStatus(status);
        setTotalPrice(totalPrice);
    }

    public OrderVivo() {}


    // Getters
    public UUID getId() { return id; }
    public Integer getUserId() { return userId; }
    public Status getStatus() { return status; }
    public Double getTotalPrice() { return totalPrice; }
    public List<Item> getItems() { return items; }


    // Setters
    public void setId(UUID id) { this.id = id; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public void setStatus(Status status) { this.status = status; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }
    public void setItems(List<Item> items) { this.items = items; }
    
}
