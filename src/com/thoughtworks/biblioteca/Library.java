package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Library {
    private List<Book> books;
    private PrintStream out;

    public Library(List<Book> books, PrintStream out) {

        this.books = books;
        this.out = out;
    }

    public void welcome() {
        out.println("Welcome!");
    }

    public void displayBooks() {
        for (Book book : books) {
            out.println(book.getDetails());
        }
    }

    public void displayBooksWithNumbers() {
        for (int i=1; i<=books.size(); i++) {
            out.print(i + ". ");
            out.println(books.get(i-1).getDetails());
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
