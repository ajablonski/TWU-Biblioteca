package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Application {

    private Menu menu;
    private PrintStream out;
    private BufferedReader in;


    public Application(PrintStream out, BufferedReader in, Menu menu) {
        this.out = out;
        this.in = in;
        this.menu = menu;
    }

    public void start() {
        menu.welcome();
        menu.display();
        out.println("Q. Quit");
        out.print("Enter option number: ");
        String input = getInput();

        while (!input.equals("Q")) {
            menu.choose(input);
            menu.display();
            out.println("Q. Quit");
            out.print("Enter option number: ");
            input = getInput();
        }
    }

    public String getInput() {
        try {
            return this.in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
