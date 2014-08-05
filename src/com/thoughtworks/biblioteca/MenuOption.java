package com.thoughtworks.biblioteca;

public interface MenuOption {
    void execute();

    String getName();

    boolean needsLogin();

    boolean displayIfLoggedIn();
}
