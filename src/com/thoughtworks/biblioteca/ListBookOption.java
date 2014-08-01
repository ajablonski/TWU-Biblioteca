package com.thoughtworks.biblioteca;

public class ListBookOption implements MenuOption {

    private Library library;

    public ListBookOption(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        library.displayBooks();
    }

    public String getName() {
        return "List Book";
    }
}
