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
        try {
            int bookToRemoveIndex = Integer.parseInt(selection) - 1;
            books.remove(bookToRemoveIndex);
            out.println("Thank you! Enjoy your book.");
        } catch (IndexOutOfBoundsException ex) {
            out.println("That book is not available");
            ex.printStackTrace();
        }
    }

    public void displayBooksWithNumbers() {
        for (int i=1; i<=books.size(); i++) {
            out.print(i + ". ");
            out.println(books.get(i-1).getDetails());
        }
    }

    public String getName() {
        return "Check Out";
    }

//    public void execute(String s, List<Book> books) {
//        try {
//            int bookToRemoveIndex = Integer.parseInt(s) - 1;
//            books.remove(bookToRemoveIndex);
//            out.println("Thank you! Enjoy your book.");
//        } catch (IndexOutOfBoundsException ex) {
//            out.println("That book is not available");
//            ex.printStackTrace();
//        }
//    }
}
