package com.challenge.backend.model.classes;

public class Rating {
    
    // Properties
    private double rate;
    private int count;


    // Constructor
    public Rating(double rate, int count) {
        this.rate = rate;
        this.count = count;
    }


    // Getters
    public double getRate() { return this.rate; }
    public int getCount() { return this.count; }


    // Setters
    public void setRate(double rate) { this.rate = rate; }
    public void setCount(int count) { this.count = count; }
    
}
