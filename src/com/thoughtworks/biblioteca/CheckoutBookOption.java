package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class CheckoutBookOption implements MenuOption {

    private final PrintStream out;
    private final BufferedReader in;
    private List<Book> books;

    public CheckoutBookOption(List<Book> books, PrintStream out, BufferedReader in) {
        this.out = out;
        this.in = in;
        this.books = books;
    }

    private String getSelection() {
        String bookChoice = "";
        displayBooksWithNumbers();
        out.print("Choose a book: ");
        try {
             bookChoice = in.readLine();
            //execute(bookChoice, library.getBooks());
        } catch (IOException e) {
            out.println("Invalid book choice");
            e.printStackTrace();
        }
        return bookChoice;
    }

    @Override
    public void execute() {
        String selection = getSelection();
        int choice = Integer.parseInt(selection) - 1;
        if (choice < books.size() &&
            !books.get(choice).isCheckedOut()) {
            books.get(choice).checkOut();
            out.println("Thank you! Enjoy your book.");
        } else {
            out.println("That book is not available");
        }
    }

    public void displayBooksWithNumbers() {
        for (int i=1; i<=books.size(); i++) {
            if (!books.get(i-1).isCheckedOut()) {
                out.println(i + ". " + books.get(i-1).getDetails());
            }
        }
    }

    public String getName() {
        return "Check out book";
    }

    public boolean needsLogin() {
        return true;
    }

    @Override
    public boolean displayIfLoggedIn() {
        return true;
    }
}
