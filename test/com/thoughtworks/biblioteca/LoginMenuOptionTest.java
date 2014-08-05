package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginMenuOptionTest {
    private LoginMenuOption option;
    private PrintStream out;
    private BufferedReader in;
    private Session fakeSession;


    @Before
    public void setUp() {
        out = mock(PrintStream.class);
        in = mock(BufferedReader.class);
        fakeSession = mock(Session.class);
        option = new LoginMenuOption(out, in, fakeSession);
    }

    @Test
    public void shouldPromptUserForLibraryNumber() {
        option.getLibraryNumber();

        verify(out).print("Enter library number: ");
    }

    @Test
    public void shouldGetLibraryNumberFromUser() throws IOException {
        when(in.readLine()).thenReturn("111");
        assertEquals(option.getLibraryNumber(), "111");
    }

    @Test
    public void shouldPromptUserForPassword() {
        option.getPassword();

        verify(out).print("Enter password: ");
    }

    @Test
    public void shouldGetPasswordFromUser() throws IOException {
        when(in.readLine()).thenReturn("password");
        assertEquals(option.getPassword(), "password");
    }

    @Test
    public void shouldAttemptLogin() throws IOException {
        when(in.readLine()).thenReturn("111", "password");

        option.execute();

        verify(fakeSession).attemptLogin("111", "password");
    }

    @Test
    public void shouldGetName() {
        assertEquals("Log in", option.getName());
    }

    @Test
    public void shouldNotRequireUserLogin() {
        assertFalse(option.needsLogin());
    }

    @Test
    public void shouldDisplayIfLoggedIn() {
        assertFalse(option.displayIfLoggedIn());
    }

}