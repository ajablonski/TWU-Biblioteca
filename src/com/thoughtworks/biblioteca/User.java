package com.thoughtworks.biblioteca;

public class User {

    private String libraryNumber;
    private String password;

    public User(String libraryNumber, String password){
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getLibraryNumber() {
        return this.libraryNumber;
    }

    public boolean hasPassword(String passwordAttempt){
        return passwordAttempt.equals(password);
    }

}
