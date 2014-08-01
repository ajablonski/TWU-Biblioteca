package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    private PrintStream fakePrintStream;


    @Before
    public void setup(){
        fakePrintStream = mock(PrintStream.class);
    }

    @Test
    public void shouldPrintOneBookWhenLibraryHasOneBook() {
        List<Book> oneBook = new ArrayList<Book>();
        Book book1 = mock(Book.class);
        oneBook.add(book1);
        Library myLibrary = new Library(oneBook, fakePrintStream);

        myLibrary.displayBooks();

        verify(book1).getDetails();
    }

    @Test
    public void shouldPrintBooksWhenLibraryHasMultipleBooks(){
        List<Book> books = new ArrayList<Book>();
        books.add(mock(Book.class));
        books.add(mock(Book.class));
        Library myLibrary = new Library(books, fakePrintStream);

        myLibrary.displayBooks();

        verifyBookListPrinted(books);
    }

    @Test
    public void shouldListBooksWithNumbers() {
        List<Book> books = new ArrayList<Book>();
        books.add(mock(Book.class));
        books.add(mock(Book.class));
        Library myLibrary = new Library(books, fakePrintStream);

        myLibrary.displayBooksWithNumbers();

        verifyBookListPrinted(books);

        verify(fakePrintStream).print("1. ");
        verify(fakePrintStream).print("2. ");
    }

    @Test
    public void shouldPrintNothingWhenLibraryIsEmpty(){
        List<Book> noBooks = new ArrayList<Book>();
        Library myLibrary = new Library(noBooks, fakePrintStream);

        myLibrary.displayBooks();
        verify(fakePrintStream, times(0)).println();
    }

    @Test
    public void welcomeMessage(){
        List<Book> books = new ArrayList<Book>();
        Library myLibrary = new Library(books, fakePrintStream);

        myLibrary.welcome();
        verify(fakePrintStream).println("Welcome!");
    }

    private void verifyBookListPrinted(List<Book> books) {
        for (Book book : books) {
            verify(book).getDetails();
        }
    }

    @Test
    public void shouldCheckoutBook(){
        List<Book> books = new ArrayList<Book>();
        books.add(mock(Book.class));
        books.add(mock(Book.class));
        Library myLibrary = new Library(books, fakePrintStream);
        myLibrary.checkOut("1");
        assertThat(myLibrary.getBooks().size(), is(1));
    }

}