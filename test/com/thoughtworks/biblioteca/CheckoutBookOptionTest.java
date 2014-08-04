package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutBookOptionTest {

    private Library library;
    private CheckoutBookOption checkoutBookOption;
    private PrintStream fakePrintStream;
    private BufferedReader fakeBufferedReader;
    private List<Book> books;
    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        fakePrintStream = mock(PrintStream.class);
        fakeBufferedReader = mock(BufferedReader.class);
        Book book = new Book("Title1",
                "Author1",
                "2001");
        Book book2 = new Book("Title2",
                "Author2",
                "2002");
        List<Book> books = new ArrayList<Book>();
        books.add(book);
        books.add(book2);
        checkoutBookOption = new CheckoutBookOption(books, fakePrintStream, fakeBufferedReader);
    }

    /*@Before
    public void shouldPrintChooseABookOnExecute(){
        checkoutBookOption.execute();

        verify(fakePrintStream).print("Choose a book: ");
    }*/

    @Test
    public void shouldCheckoutBookOnExecute() throws Exception {
        when(fakeBufferedReader.readLine()).thenReturn("1");

        when(library.getBooks()).thenReturn(books);
        checkoutBookOption.execute();
        verify(fakePrintStream).println("Thank you! Enjoy your book.");
    }

    @Test
    public void shouldDisplayMessageWhenAttemptToCheckoutCheckedoutBook() throws Exception {
        when(fakeBufferedReader.readLine()).thenReturn("3");
        Book book = new Book("Title1",
                "Author1",
                "2001");
        Book book2 = new Book("Title2",
                "Author2",
                "2002");
        List<Book> books = new ArrayList<Book>();
        books.add(book);
        books.add(book2);
        when(library.getBooks()).thenReturn(books);
        checkoutBookOption.execute();
        verify(fakePrintStream).println("That book is not available");
    }

//    @Test
//    public void shouldCheckoutBook(){
//        List<Book> books = new ArrayList<Book>();
//        books.add(mock(Book.class));
//        books.add(mock(Book.class));
//        Library myLibrary = new Library(books, fakePrintStream);
//        myLibrary.execute("1");
//        assertThat(myLibrary.getBooks().size(), is(1));
//    }
}