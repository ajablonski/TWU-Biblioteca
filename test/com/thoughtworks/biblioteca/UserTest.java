package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp(){
        user = new User("111", "password");
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

}