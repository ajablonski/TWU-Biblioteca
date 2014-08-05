package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class CheckoutBookOptionTest {

    private CheckoutBookOption checkoutBookOption;
    private PrintStream fakePrintStream;
    private BufferedReader fakeBufferedReader;
    private List<Book> books;

    @Before
    public void setUp() throws Exception {
        fakePrintStream = mock(PrintStream.class);
        fakeBufferedReader = mock(BufferedReader.class);
        books = new ArrayList<Book>();
        books.add(mock(Book.class));
        books.add(mock(Book.class));
        checkoutBookOption = new CheckoutBookOption(books, fakePrintStream, fakeBufferedReader);
    }

    @Test
    public void shouldDisplayMessageOnSuccessfulCheckout() throws Exception {
        when(fakeBufferedReader.readLine()).thenReturn("1");
        checkoutBookOption.execute();

        verify(fakePrintStream).println("Thank you! Enjoy your book.");
    }

    @Test
    public void shouldDisplayMessageWhenAttemptToCheckoutCheckedoutBook() throws Exception {
        when(fakeBufferedReader.readLine()).thenReturn("3");

        checkoutBookOption.execute();

        verify(fakePrintStream).println("That book is not available");
    }

    @Test
    public void shouldCheckoutBookOnCheckout() throws IOException {
        when(fakeBufferedReader.readLine()).thenReturn("3");
        Book book = mock(Book.class);
        when(book.isCheckedOut()).thenReturn(false);
        books.add(book);
        checkoutBookOption.execute();
        verify(book).checkOut();
    }

    @Test
    public void shouldNotCheckoutCheckedOutBook() throws IOException {
        when(fakeBufferedReader.readLine()).thenReturn("3");
        Book book = mock(Book.class);
        when(book.isCheckedOut()).thenReturn(true);
        books.add(book);
        checkoutBookOption.execute();
        verify(book, never()).checkOut();
    }

    @Test
    public void shouldOnlyDisplayAvailableBooks() {
        when(books.get(0).isCheckedOut()).thenReturn(false);
        when(books.get(0).getDetails()).thenReturn("test details");
        when(books.get(1).isCheckedOut()).thenReturn(true);
        checkoutBookOption.displayBooksWithNumbers();
        verify(fakePrintStream).println("1. test details");
    }

    @Test
    public void shouldNotDisplayUnavailableBooks() {
        when(books.get(0).isCheckedOut()).thenReturn(false);
        when(books.get(1).isCheckedOut()).thenReturn(true);
        checkoutBookOption.displayBooksWithNumbers();
        verify(books.get(1), never()).getDetails();
    }

    @Test
    public void shouldRequireUserLogin() {
        assertTrue(checkoutBookOption.needsLogin());
    }

    @Test
    public void shouldDisplayIfLoggedIn() {
        assertTrue(checkoutBookOption.displayIfLoggedIn());
    }

    @Test
    public void shouldGetName() {
        assertThat(checkoutBookOption.getName(), is("Check out book"));
    }
}