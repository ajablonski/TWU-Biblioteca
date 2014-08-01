package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {
    private PrintStream fakePrintStream;

    @Before
    public void setUp() {
        fakePrintStream = mock(PrintStream.class);
    }

    @Test
    public void shouldCallOptionMethod() {
        Menu menu = new Menu(fakePrintStream);
        MenuOption fakeMenuOption = mock(MenuOption.class);
        menu.addOption("1", fakeMenuOption);
        menu.choose("1");
        verify(fakeMenuOption).execute();
    }

    @Test
    public void shouldPrintErrorMessageWhenInvalidOptionIsChosen() {
        Menu menu = new Menu(fakePrintStream);
        menu.choose("1");
        verify(fakePrintStream).println("Select a valid option!");
    }
}
