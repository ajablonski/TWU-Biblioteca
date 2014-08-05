package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class ListBookOption implements MenuOption {

    private List<Book> books;
    private PrintStream out;

    public ListBookOption(List<Book> books, PrintStream out) {
        this.books = books;
        this.out = out;
    }

    @Override
    public void execute() {
       displayBooks();
    }

    public String getName() {
        return "List books";
    }

    public void displayBooks() {
        for (Book book : books) {
            out.println(book.getDetails());
        }
    }

    public boolean needsLogin() {
        return false;
    }

    public boolean displayIfLoggedIn() {
        return true;
    }
}
