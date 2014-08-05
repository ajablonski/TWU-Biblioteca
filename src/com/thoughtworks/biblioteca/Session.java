package com.thoughtworks.biblioteca;

import java.util.List;

public class Session {

    private List<User> userList;
    private User loggedInUser = null;

    public Session(List<User> userList){
        this.userList = userList;
    }

    public void attemptLogin(String libraryNumber, String password) {
        for (User user : userList) {
            if (user.getLibraryNumber().equals(libraryNumber)
                && user.hasPassword(password)) {
                loggedInUser = user;
            }
        }
    }

    public boolean userLoggedIn() {
        return loggedInUser != null;
    }

    public User getUser() {
        return loggedInUser;
    }
}
