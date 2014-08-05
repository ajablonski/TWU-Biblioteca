package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListMovieMenuOptionTest {
    MenuOption listMovieMenuOption;
    PrintStream out;
    List<Movie> movies;

    @Before
    public void setUp() {
        out = mock(PrintStream.class);
        movies = new ArrayList<Movie>();
        Movie fakeMovie = mock(Movie.class);
        when(fakeMovie.getDetails()).thenReturn("Test");
        movies.add(fakeMovie);
        listMovieMenuOption = new ListMovieMenuOption(movies, out);
    }

    @Test
    public void shouldDisplayMoviesOnExecute() {
        listMovieMenuOption.execute();
        verify(out).println("Test");
    }

    @Test
    public void shouldReturnOptionName() {
        assertEquals(listMovieMenuOption.getName(), "List Movies");
    }

    @Test
    public void shouldNotRequireLogin() {
        assertFalse(listMovieMenuOption.needsLogin());
    }
}