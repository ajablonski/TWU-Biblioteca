package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class UserInfoMenuOption implements MenuOption {
    private final PrintStream out;
    private final Session session;

    public UserInfoMenuOption(Session session, PrintStream out) {
        this.session = session;
        this.out = out;
    }

    @Override
    public void execute() {
        User user = session.getUser();
        out.println(user.getInfo());
    }

    @Override
    public String getName() {
        return "Get user information";
    }

    @Override
    public boolean needsLogin() {
        return true;
    }

    @Override
    public boolean displayIfLoggedIn() {
        return true;
    }
}
