package com.challenge.backend.model.classes;

public class User {

    //Properties
    private Address address;
    private int id;
    private String email;
    private String username;
    private String password;
    private Name name;
    private String phone;
    private int __v;

    //Constructor
    public User(Address address, int id, String email, String username, String password, Name name, String phone, int __v) {
        setAddress(address);
        setId(id);
        setEmail(email);
        setUsername(username);
        setPassword(password);
        setName(name);
        setPhone(phone);
        set__v(__v);
    }


    //Getters
    public Address getAddress() { return this.address; }
    public int getId() { return this.id; }
    public String getEmail() { return this.email; }
    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }
    public Name getName() { return this.name; }
    public String getPhone() { return this.phone; }
    public int get__v() { return this.__v; }


    //Setters
    public void setAddress(Address address) { this.address = address; }
    public void setId(int id) { this.id = id; }
    public void setEmail(String email) { this.email = email; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setName(Name name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void set__v(int __v) { this.__v = __v; }
}
