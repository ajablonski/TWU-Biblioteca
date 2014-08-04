package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class ReturnBookMenuOption implements MenuOption{

    private final List<Book> books;
    private final BufferedReader in;
    private final PrintStream out;

    public ReturnBookMenuOption(List<Book> books, BufferedReader in, PrintStream out) {
        this.books = books;
        this.in = in;
        this.out = out;
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

    public void execute() {
        String selection = getSelection();
        int choice = Integer.parseInt(selection) - 1;
        if (choice < books.size() &&
                books.get(choice).isCheckedOut()) {
            books.get(choice).checkIn();
            out.println("Thank you for returning the book.");
        } else {
            out.println("That is not a valid book to return.");
        }
    }

    public void displayBooksWithNumbers() {
        for (int i=1; i<=books.size(); i++) {
            if(books.get(i-1).isCheckedOut()) {
                out.print(i + ". ");
                out.println(books.get(i-1).getDetails());
            }
        }
    }

    public String getName() {
        return "Return book";
    }
}
