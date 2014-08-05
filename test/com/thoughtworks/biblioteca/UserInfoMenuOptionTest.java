package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserInfoMenuOptionTest {
    private UserInfoMenuOption option;
    private Session mockSession;
    private PrintStream fakePrintStream;
    private User mockUser;

    @Before
    public void setUp() throws Exception {
        mockSession = mock(Session.class);
        mockUser = mock(User.class);
        when(mockSession.getUser()).thenReturn(mockUser);
        fakePrintStream = mock(PrintStream.class);
        option = new UserInfoMenuOption(mockSession, fakePrintStream);
    }

    @Test
    public void shouldGetOptionName() {
        assertThat(option.getName(), is("Get user information"));
    }

    @Test
    public void shouldRequireUserLoggedIn() {
        assertThat(option.needsLogin(), is(true));
    }

    @Test
    public void shouldDisplayIfLoggedIn() {
        assertThat(option.displayIfLoggedIn(), is(true));
    }

    @Test
    public void shouldGetUserOnExecute() {
        option.execute();
        verify(mockSession).getUser();
    }

    @Test
    public void shouldPrintUserInfoOnExecute() {
        when(mockUser.getInfo()).thenReturn("Test");
        option.execute();
        verify(fakePrintStream).println("Test");
    }

}