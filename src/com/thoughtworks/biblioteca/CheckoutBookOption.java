package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class CheckoutBookOption implements MenuOption {

    private final PrintStream out;
    private final Library library;
    private final BufferedReader in;

    public CheckoutBookOption(Library library, PrintStream out, BufferedReader in) {
        this.library = library;
        this.out = out;
        this.in = in;
    }

    @Override
    public void execute() {
        library.displayBooksWithNumbers();
        out.print("Choose a book: ");
        try {
            String bookChoice = in.readLine();
            library.checkOut(bookChoice);
        } catch (IOException e) {
            out.println("Invalid book choice");
            e.printStackTrace();
        }
    }
}
