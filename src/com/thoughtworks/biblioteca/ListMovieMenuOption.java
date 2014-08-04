package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class ListMovieMenuOption implements MenuOption{
    private List<Movie> movies;
    private PrintStream out;

    public ListMovieMenuOption(List<Movie> movies, PrintStream out) {
        this.movies = movies;
        this.out = out;
    }

    @Override
    public void execute() {
        for (Movie movie : movies){
            out.println(movie.getDetails());
        }
    }

    @Override
    public String getName() {
        return "List Movies";
    }
}
