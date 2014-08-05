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

public class ReturnBookMenuOptionTest  {
    private PrintStream fakePrintStream;
    private BufferedReader fakeBufferedReader;
    private List<Book> books;
    private ReturnBookMenuOption returnOption;

    @Before
    public void setUp() throws Exception {
        fakePrintStream = mock(PrintStream.class);
        fakeBufferedReader = mock(BufferedReader.class);
        Book book = mock(Book.class);
        Book book2 = mock(Book.class);
        books = new ArrayList<Book>();
        books.add(book);
        books.add(book2);
        returnOption = new ReturnBookMenuOption(books, fakeBufferedReader, fakePrintStream);
    }

    @Test
    public void shouldReturnBookOnExecute() throws Exception {
        when(books.get(0).isCheckedOut()).thenReturn(true);
        when(fakeBufferedReader.readLine()).thenReturn("1");
        returnOption.execute();
        verify(books.get(0)).checkIn();
    }

    @Test
    public void shouldNotReturnACheckedInBook() throws IOException {
        when(books.get(0).isCheckedOut()).thenReturn(false);
        when(fakeBufferedReader.readLine()).thenReturn("1");
        returnOption.execute();
        verify(books.get(0), never()).checkIn();
    }

    @Test
    public void shouldGetOptionName() {
        assertThat(returnOption.getName(), is("Return book"));
    }

    @Test
    public void shouldOnlyDisplayCheckedOutBooks() {
        when(books.get(0).isCheckedOut()).thenReturn(false);
        when(books.get(1).isCheckedOut()).thenReturn(true);
        returnOption.displayBooksWithNumbers();
        verify(books.get(0), never()).getDetails();
        verify(books.get(1)).getDetails();
    }

    @Test
    public void shouldPrintMessageOnSuccessfulReturn() throws IOException {
        when(books.get(0).isCheckedOut()).thenReturn(true);
        when(fakeBufferedReader.readLine()).thenReturn("1");
        returnOption.execute();
        verify(fakePrintStream).println("Thank you for returning the book.");
    }

    @Test
    public void shouldPrintMessageOnUnsuccessfulReturn() throws IOException {
        when(fakeBufferedReader.readLine()).thenReturn("3");
        returnOption.execute();
        verify(fakePrintStream).println("That is not a valid book to return.");

    }

    @Test
    public void shouldRequireUserLogin() {
        assertTrue(returnOption.needsLogin());
    }
}
