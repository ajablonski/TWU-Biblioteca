package com.thoughtworks.biblioteca;

public class User {

    private final String phone;
    private final String name;
    private final String email;
    private String libraryNumber;
    private String password;

    public User(String libraryNumber, String password, String name, String email, String phone){
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getLibraryNumber() {
        return this.libraryNumber;
    }

    public boolean hasPassword(String passwordAttempt){
        return passwordAttempt.equals(password);
    }

    public String getInfo() {
        return "Name: " + this.name + "\nEmail: " + this.email + "\nPhone: " + this.phone;
    }
}
