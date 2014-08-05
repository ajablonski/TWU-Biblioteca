package com.thoughtworks.biblioteca;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp(){
        user = new User("111", "password", "User Name", "user@email.com", "555-5555");
    }

    @Test
    public void shouldReturnTrueWhenPasswordIsCorrect(){
        assertTrue(user.hasPassword("password"));
    }

    @Test
    public void shouldReturnFalseWhenPasswordIsIncorrect(){
        assertFalse(user.hasPassword("foo"));
    }

    @Test
    public void shouldGetUserLibraryNumber() {
        assertEquals(user.getLibraryNumber(), "111");
    }

    @Test
    public void shouldGetUserInformation() {
        assertThat(user.getInfo(), Matchers.containsString("Name: User Name"));
        assertThat(user.getInfo(), Matchers.containsString("Email: user@email.com"));
        assertThat(user.getInfo(), Matchers.containsString("Phone: 555-5555"));
    }

}