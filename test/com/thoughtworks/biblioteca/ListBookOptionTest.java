package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBookOptionTest {

    private ListBookOption listBookOption;
    private PrintStream out;
    private List<Book> listOfBooks;

    @Before
    public void setUp() throws Exception {
        listOfBooks = new ArrayList<Book>();
        listOfBooks.add(mock(Book.class));
        listOfBooks.add(mock(Book.class));
        out = mock(PrintStream.class);
        listBookOption = new ListBookOption(listOfBooks, out);
    }

    @Test
    public void shouldListBooksOnExecute() {
        listBookOption.execute();
        for (Book book: listOfBooks) {
            verify(book).getDetails();
        }
    }

}