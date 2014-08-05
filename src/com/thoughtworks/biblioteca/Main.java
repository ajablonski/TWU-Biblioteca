package com.thoughtworks.biblioteca;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> listOfUsers = new ArrayList<User>();
        listOfUsers.add(new User("111-1111", "password", "User Name", "user@email.com", "555-5555"));
        List<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("Book 1", "Author 1", "2001"));
        listOfBooks.add(new Book("Book 2", "Author 2", "2002"));
        List<Movie> listOfMovies = new ArrayList<Movie>();
        listOfMovies.add(new Movie("Movie 1", "2011", "Director 1", 10));
        listOfMovies.add(new Movie("Movie 2", "2012", "Director 2", 0));

        Session session = new Session(listOfUsers);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Menu menu = makeMenu(listOfBooks, listOfMovies, session, in);

        new Application(System.out, in, menu).start();
    }

    private static Menu makeMenu(List<Book> listOfBooks, List<Movie> listOfMovies, Session session, BufferedReader in) {
        Menu menu = new Menu(System.out, session);
        menu.addOption(new ListBookOption(listOfBooks, System.out));
        menu.addOption(new CheckoutBookOption(listOfBooks, System.out, in));
        menu.addOption(new ReturnBookMenuOption(listOfBooks, in, System.out));
        menu.addOption(new ListMovieMenuOption(listOfMovies, System.out));
        menu.addOption(new CheckoutMovieMenuOption(listOfMovies, System.out, in));
        menu.addOption(new LoginMenuOption(System.out, in, session));
        menu.addOption(new UserInfoMenuOption(session, System.out));
        return menu;
    }
}
