package com.challenge.backend.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geolocation {

    // Properties
    private String lat;
    
    @JsonProperty("long") 
    private String mylong;


    // Constructors
    public Geolocation(String lat, String mylong) {
        setLat(lat);
        setMylong(mylong);
    }


    // Getters
    public String getLat() { return this.lat; }
    public String getMylong() { return this.mylong; }


    // Setters
    public void setLat(String lat) { this.lat = lat; }
    public void setMylong(String mylong) { this.mylong = mylong; }

}