package com.challenge.backend.model.DTOs;

import java.util.ArrayList;

public class CreateOrderDto {
    
    // Properties
    private int userId;
    private ArrayList<ProductDto> products;


    // Constructors
    public CreateOrderDto(int userId, ArrayList<ProductDto> products) {
        setUserId(userId);
        setProducts(products);
    }
    

    // Getters
    public int getUserId() { return this.userId; }
    public ArrayList<ProductDto> getProducts() { return this.products; }

    // Setters
    public void setUserId(int userId) { this.userId = userId; }
    public void setProducts(ArrayList<ProductDto> products) { this.products = products; };
}
