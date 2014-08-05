package com.thoughtworks.biblioteca;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> listOfUsers = new ArrayList<User>();
        listOfUsers.add(new User("111-1111", "password", "User Name", "user@email.com", "555-5555"));
        Session session = new Session(listOfUsers);
        Menu menu = new Menu(System.out, session);
        List<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("Book 1", "Author 1", "2001"));
        listOfBooks.add(new Book("Book 2", "Author 2", "2002"));
        List<Movie> listOfMovies = new ArrayList<Movie>();
        listOfMovies.add(new Movie("Movie 1", "2011", "Director 1", 10));
        listOfMovies.add(new Movie("Movie 2", "2012", "Director 2", 0));
        menu.addOption(new ListBookOption(listOfBooks, System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        menu.addOption(new CheckoutBookOption(listOfBooks, System.out, in));
        menu.addOption(new ReturnBookMenuOption(listOfBooks, in, System.out));
        menu.addOption(new ListMovieMenuOption(listOfMovies, System.out));
        menu.addOption(new CheckoutMovieMenuOption(listOfMovies, System.out, in));
        menu.addOption(new LoginMenuOption(System.out, in, session));
        menu.addOption(new UserInfoMenuOption(session, System.out));

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

/*
public class Main() {
    public static void main(String[] args) {
    // create buffered reader
    // create list of books
    // create Library with books
    // pass InputStream and PrintStream to menu
    // add menu option1 to menu
    // add menu option2 to menu
    }
}
 */