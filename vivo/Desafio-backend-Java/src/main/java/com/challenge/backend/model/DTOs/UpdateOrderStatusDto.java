package com.challenge.backend.model.DTOs;

import java.util.UUID;

//Classes
import com.challenge.backend.model.enums.Status;

public class UpdateOrderStatusDto {
    
    // Properties
    private UUID id;
    private int userId;
    private Status status;


    // Constructors
    public UpdateOrderStatusDto(UUID id, int userId, Status status) {
        setId(id);
        setUserId(userId);
        setStatus(status);
    }

    public UpdateOrderStatusDto() {}
    

    // Getters
    public UUID getId() { return this.id; }
    public int getUserId() { return this.userId; }
    public Status getStatus() { return this.status; }
 

    // Setters
    public void setId(UUID id) { this.id = id; };
    public void setUserId(int userId) { this.userId = userId; }
    public void setStatus(Status status) { this.status = status; }

}
