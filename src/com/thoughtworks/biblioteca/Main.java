package com.thoughtworks.biblioteca;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu(System.out);
        Library library = library();
        menu.addOption("1", new ListBookOption(library));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        menu.addOption("2", new CheckoutBookOption(library, System.out, in));

        new Application(library(), System.out, in, menu).start();
    }

    private static Library library() {
        List<Book> listOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Book 1", "Author 1", "2001");
        Book book2 = new Book("Book 2", "Author 2", "2002");
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        return new Library(listOfBooks, System.out);
    }
}
