package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    private Library library;
    private Application application;
    private PrintStream fakePrintStream;
    private BufferedReader fakeInputStream;
    private Menu fakeMenu;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        fakePrintStream = mock(PrintStream.class);
        fakeInputStream = new BufferedReader(new StringReader("1\nQ"));
        fakeMenu = mock(Menu.class);
        application = new Application(library, fakePrintStream, fakeInputStream, fakeMenu);
    }

    @Test
    public void shouldWelcomeUserWhenStarting(){
        application.start();
        verify(fakeMenu).welcome();
    }

    @Test
    public void shouldGetUserInput(){
        assertThat(application.getInput(), is("1"));
    }

    @Test
    public void shouldLoopUntilQuit() {
        Application app = new Application(library, fakePrintStream, new BufferedReader(new StringReader("1\n1\nQ")), fakeMenu);
        app.start();
        verify(fakeMenu, times(2)).choose("1");
    }

    @Test
    public void shouldChooseAppropriateMenuOption() {
        Application app = new Application(library, fakePrintStream, new BufferedReader(new StringReader("1\nQ")), fakeMenu);
        app.start();
        verify(fakeMenu).choose("1");
    }
}