package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class LoginMenuOption implements MenuOption {
    private PrintStream out;
    private BufferedReader in;
    private Session session;

    public LoginMenuOption(PrintStream out, BufferedReader in, Session session) {
        this.out = out;
        this.in = in;
        this.session = session;
    }

    @Override
    public void execute() {
        session.attemptLogin(getLibraryNumber(), getPassword());
    }

    @Override
    public String getName() {
        return "Log in";
    }

    public String getLibraryNumber() {
        return getInput("Enter library number: ");
    }

    public String getPassword() {
        return getInput("Enter password: ");
    }

    private String getInput(String prompt) {
        out.print(prompt);
        String response = "";
        try {
            response = in.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public boolean needsLogin() {
        return false;
    }
}
