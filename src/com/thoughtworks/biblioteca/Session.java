package com.thoughtworks.biblioteca;

import java.util.List;

public class Session {

    private List<User> userList;
    private boolean loggedIn = false;

    public Session(List<User> userList){
        this.userList = userList;
    }

    public void attemptLogin(String libraryNumber, String password) {
        for (User user : userList) {
            if (user.getLibraryNumber().equals(libraryNumber)
                && user.hasPassword(password)) {
                loggedIn = true;
            }
        }
    }

    public boolean userLoggedIn() {
        return loggedIn;
    }
}
