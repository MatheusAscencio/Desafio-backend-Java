package com.challenge.backend.model.classes;

public class Product {

    // Properties
    private Integer id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;
    
    
    // Constructor
    public Product(Integer id, String title, Double price, String description, String category, String image, Rating rating) {
        setId(id);
        setTitle(title);
        setPrice(price);
        setDescription(description);
        setCategory(category);
        setImage(image);
        setRating(rating);
    }
    
    
    // Getters
    public int getId() { return this.id; }
    public String getTitle() { return this.title; }
    public double getPrice() { return this.price; }
    public String getDescription() { return this.description; }
    public String getCategory() { return this.category; }
    public String getImage() { return this.image; }
    public Rating getRating() { return this.rating; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setPrice(double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(String category) { this.category = category; }
    public void setImage(String image) { this.image = image; }
    public void setRating(Rating rating) { this.rating = rating; }
    
}
