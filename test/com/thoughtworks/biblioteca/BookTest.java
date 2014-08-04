package com.thoughtworks.biblioteca;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void shouldGetBookDetails(){
        Book book = new Book("Book Name", "Book Author", "2000");
        assertThat(book.getDetails(), Matchers.containsString("Book Name"));
        assertThat(book.getDetails(), Matchers.containsString("Book Author"));
        assertThat(book.getDetails(), Matchers.containsString("2000"));
    }

    @Test
    public void shouldInsertEllipsesWhenBookTitleIsTooLong(){

        Book book = new Book("This is a really really really really really long book title!",
                "Alex Jablonskiiiiiiiiiiiiiiiiiiiiii",
                "2000");
        assertThat(book.getDetails(), Matchers.containsString("This is a really really rea..."));
        assertThat(book.getDetails(), Matchers.containsString("Alex Jablonskiiiiiiiiiiiiii..."));
        assertThat(book.getDetails(), Matchers.containsString("2000"));
    }

    @Test
    public void shouldSayIfCheckedOut() {
        Book book = new Book("Book 1", "Author 1", "2001");
        assertThat(book.isCheckedOut(), is(false));
    }

    @Test
    public void shouldCheckOut() {
        Book book = new Book("Book 1", "Author 1", "2001");
        book.checkOut();
        assertThat(book.isCheckedOut(), is(true));
    }

    @Test
    public void shouldCheckIn() {
        Book book = new Book("Book 1", "Author 1", "2001");
        book.checkOut();
        book.checkIn();
        assertThat(book.isCheckedOut(), is(false));
    }
}