package com.challenge.backend.model.DTOs;

import java.util.UUID;
import java.util.ArrayList;

//Classes
import com.challenge.backend.model.enums.Status;

public class UpdateOrderDto {
    
    // Properties
    private UUID id;
    private int userId;
    private ArrayList<ProductDto> items;


    // Constructors
    public UpdateOrderDto(UUID id, int userId, Status status, ArrayList<ProductDto> items) {
        setId(id);
        setUserId(userId);
        setItems(items);
    }

    public UpdateOrderDto() {}
    

    // Getters
    public UUID getId() { return this.id; }
    public int getUserId() { return this.userId; }
    public ArrayList<ProductDto> getItems() { return this.items; }

    // Setters
    public void setId(UUID id) { this.id = id; };
    public void setUserId(int userId) { this.userId = userId; }
    public void setItems(ArrayList<ProductDto> products) { this.items = products; };
}
