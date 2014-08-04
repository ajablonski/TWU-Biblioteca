package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.*;

public class Menu {
    private List<MenuOption> menuOptions;
    private PrintStream out;

    public Menu(PrintStream out) {
        menuOptions = new ArrayList<MenuOption>();
        this.out = out;
    }

    public void addOption(MenuOption menuOption) {
        menuOptions.add(menuOption);
    }

    public void choose(String choice) {
        int index = Integer.parseInt(choice);
        if(index <= menuOptions.size()) {
            menuOptions.get(index - 1).execute();
        } else {
            out.println("Select a valid option!");
        }
    }

    public void display() {
        for (MenuOption menuOption : menuOptions){
            out.println((menuOptions.indexOf(menuOption) + 1) + ". " + menuOption.getName());
        }
    }

    public void welcome() {
        out.println("Welcome!");
    }
}
