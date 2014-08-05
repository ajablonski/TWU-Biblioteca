package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class CheckoutMovieMenuOption implements MenuOption {

    private final List<Movie> movies;
    private final BufferedReader in;
    private PrintStream out;

    public CheckoutMovieMenuOption(List<Movie> movies, PrintStream out, BufferedReader in){
        this.out = out;
        this.movies = movies;
        this.in = in;
    }

    private String getSelection() {
        String bookChoice = "";
        displayMoviesWithNumbers();
        out.print("Choose a movie: ");
        try {
            bookChoice = in.readLine();
        } catch (IOException e) {
            out.println("Invalid movie choice");
        }
        return bookChoice;
    }

    public void displayMoviesWithNumbers() {
        for (Movie movie : movies){
            out.println((movies.indexOf(movie) + 1) + ". " + movie.getDetails());
        }
    }

    @Override
    public void execute() {
        String choiceString = getSelection();
        int choiceNumber = Integer.parseInt(choiceString);
        if (choiceNumber <= movies.size() &&
                !movies.get(choiceNumber - 1).isCheckedOut()) {
            out.println("Thank you! Enjoy the movie.");
            movies.get(choiceNumber - 1).checkOut();

        } else {
            out.println("That movie is not available");
        }

    }

    @Override
    public String getName() {
        return null;
    }
}
