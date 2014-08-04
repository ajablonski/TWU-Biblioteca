package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {
    private Map<String, MenuOption> menuOptions;
    private PrintStream out;

    public Menu(PrintStream out) {
        menuOptions = new LinkedHashMap<String, MenuOption>();
        this.out = out;
    }

    public void addOption(String key, MenuOption menuOption) {
        menuOptions.put(key, menuOption);
    }

    public void choose(String choice) {
        if(menuOptions.containsKey(choice)) {
            menuOptions.get(choice).execute();
        } else {
            out.println("Select a valid option!");
        }
    }

    public void display() {
        for (Map.Entry<String, MenuOption> keyValuePair : menuOptions.entrySet()) {
            out.println(keyValuePair.getKey() + ". " + keyValuePair.getValue().getName());
        }
    }

    public void welcome() {
        out.println("Welcome!");
    }
}
