package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SessionTest {

    private Session session;
    private User mockUser;
    
    @Before
    public void setUp(){
        mockUser = mock(User.class);
        when(mockUser.getLibraryNumber()).thenReturn("111");
        List<User> users = new ArrayList<User>();
        users.add(mockUser);
        session = new Session(users);
    }

    @Test
    public void shouldLogInUserWithValidCredentials(){
        when(mockUser.hasPassword(anyString())).thenReturn(true);
        session.attemptLogin("111", "password");
        assertTrue(session.userLoggedIn());
    }

    @Test
    public void shouldNotLogInUserWithInvalidCredentials(){
        when(mockUser.hasPassword(anyString())).thenReturn(false);
        session.attemptLogin("111", "wrongPass");
        assertFalse(session.userLoggedIn());
    }

    @Test
    public void shouldReturnLoggedInUser() {
        when(mockUser.hasPassword(anyString())).thenReturn(true);
        session.attemptLogin("111", "password");
        assertThat(session.getUser(), is(mockUser));
    }

    @Test
    public void shouldReturnNullWhenNoUserLoggedIn() {
        assertNull(session.getUser());
    }

}