package com.thoughtworks.biblioteca;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void shouldGetDetails() {
        Movie movie = new Movie("MovieName", "2000", "MovieDirector", 5);
        assertThat(movie.getDetails(), Matchers.containsString("MovieName"));
        assertThat(movie.getDetails(), Matchers.containsString("2000"));
        assertThat(movie.getDetails(), Matchers.containsString("MovieDirector"));
        assertThat(movie.getDetails(), Matchers.containsString("5"));
    }

    @Test
    public void shouldSayIfCheckedOut() {
        Movie movie = new Movie("Movie 1", "2001", "Director", 8);
        assertThat(movie.isCheckedOut(), is(false));
    }

    @Test
    public void shouldCheckOut() {
        Movie movie = new Movie("Movie 1", "2001", "Director", 8);
        movie.checkOut();
        assertThat(movie.isCheckedOut(), is(true));
    }

    @Test
    public void shouldCheckIn() {
        Movie movie = new Movie("Movie 1", "2001", "Director", 8);
        movie.checkOut();
        movie.checkIn();
        assertThat(movie.isCheckedOut(), is(false));
    }

    @Test
    public void shouldDisplayUnratedIfMovieRatingIsZero() {
        Movie movie = new Movie("Movie 1", "2001", "Director", 0);
        assertThat(movie.getDetails(), Matchers.containsString("unrated"));
    }

}