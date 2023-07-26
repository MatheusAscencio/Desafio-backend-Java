package com.challenge.backend.model.classes;

public class Name{
    
    // Properties
    private String firstname;
    private String lastname;


    // Constructor
    public Name(String firstname, String lastname) {
        setFirstname(firstname);
        setLastname(lastname);
    }


    // Getters
    public String getFirstname() { return this.firstname; }
    public String getLastname() { return this.lastname; }


    // Setters
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    
}