package com.challenge.backend.model.entities;

import org.springframework.data.annotation.PersistenceCreator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
    
    // Properties
    @Id
    private Integer id;
    
    @Column(nullable = false)
    private Double price;
    
    @Column(nullable = false)
    private Integer amount;
    
    @Column(nullable = false)
    private Double partialAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order", nullable = true)
    @JsonBackReference
    private OrderVivo order;

    // Constructors
    @PersistenceCreator
    public Item(Integer id, Double price, Integer amount, Double pa) {
        setId(id);
        setPrice(price);
        setAmount(amount);
        setPA(pa);
    }

    public Item() {}


    // Getters
    public Integer getId() { return this.id; }
    public Double getPrice() { return this.price; }
    public Integer getAmount() {return this.amount; }
    public Double getPA() { return this.partialAmount; }
    public OrderVivo getOrder() { return this.order; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setPrice(Double p) { this.price = p; }
    public void setAmount(Integer amount) { this.amount = amount; }
    public void setPA(Double pa) { this.partialAmount = pa; }
    public void setOrder(OrderVivo order) { this.order = order; }
}
