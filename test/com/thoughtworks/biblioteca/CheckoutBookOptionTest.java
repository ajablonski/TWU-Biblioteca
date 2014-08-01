package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutBookOptionTest {

    private Library library;
    private CheckoutBookOption checkoutBookOption;
    private PrintStream fakePrintStream;
    private BufferedReader fakeBufferedReader;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        fakePrintStream = mock(PrintStream.class);
        fakeBufferedReader = mock(BufferedReader.class);
        when(fakeBufferedReader.readLine()).thenReturn("1");
        checkoutBookOption = new CheckoutBookOption(library, fakePrintStream, fakeBufferedReader);
    }

    @Test
    public void shouldCheckoutBookOnExecute() {
        checkoutBookOption.execute();
        verify(library).displayBooksWithNumbers();
        verify(fakePrintStream).print("Choose a book: ");
        verify(library).checkOut("1");
    }
}