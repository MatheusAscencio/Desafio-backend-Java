package com.challenge.backend.model.classes;

public class Address {

    // Properties
    private Geolocation geolocation;
    private String city;
    private String street;
    private int number;
    private String zipcode;

    // Constructor
    public Address(Geolocation geolocation, String city, String street, int number, String zipcode) {
        setGeolocation(geolocation);
        setCity(city);
        setStreet(street);
        setNumber(number);
        setZipcode(zipcode);
    }


    // Getters
    public Geolocation getGeolocation() { return this.geolocation; }
    public String getCity() { return this.city; }
    public String getStreet() { return this.street; }
    public int getNumber() { return this.number; }
    public String getZipcode() { return this.zipcode; }


    // Setters
    public void setGeolocation(Geolocation geolocation) { this.geolocation = geolocation; }
    public void setCity(String city) { this.city = city; }
    public void setStreet(String street) { this.street = street; }
    public void setNumber(int number) { this.number = number; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }    
}
