package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class MenuTest {
    private PrintStream fakePrintStream;
    private Session fakeSession;

    @Before
    public void setUp() {
        fakePrintStream = mock(PrintStream.class);
        fakeSession = mock(Session.class);
    }

    @Test
    public void shouldCallOptionMethod() {
        Menu menu = new Menu(fakePrintStream, fakeSession);
        MenuOption fakeMenuOption = mock(MenuOption.class);
        menu.addOption(fakeMenuOption);
        menu.choose("1");
        verify(fakeMenuOption).execute();
    }

    @Test
    public void shouldPrintErrorMessageWhenInvalidOptionIsChosen() {
        Menu menu = new Menu(fakePrintStream, fakeSession );
        menu.choose("1");
        verify(fakePrintStream).println("Select a valid option!");
    }

    @Test
    public void shouldDisplay(){
        Menu menu = new Menu(fakePrintStream, fakeSession);
        MenuOption fakeMenuOption = mock(MenuOption.class);
        menu.addOption(fakeMenuOption);
        when(fakeMenuOption.getName()).thenReturn("Option 1");
        menu.display();
        verify(fakePrintStream).println("1. Option 1");
    }

    @Test
    public void shouldDisplayNoLoginRequiredOptionIfNotLoggedIn() {
        Menu menu = new Menu(fakePrintStream, fakeSession);
        MenuOption mockOption = mock(MenuOption.class);
        menu.addOption(mockOption);
        when(fakeSession.userLoggedIn()).thenReturn(false);
        when(mockOption.needsLogin()).thenReturn(false);
        when(mockOption.getName()).thenReturn("Test");

        menu.display();
        verify(fakePrintStream).println("1. Test");
    }

    @Test
    public void shouldNotDisplayLoginRequiredOptionIfNotLoggedIn() {
        Menu menu = new Menu(fakePrintStream, fakeSession);
        MenuOption mockOption = mock(MenuOption.class);
        menu.addOption(mockOption);
        when(fakeSession.userLoggedIn()).thenReturn(false);
        when(mockOption.needsLogin()).thenReturn(true);
        when(mockOption.getName()).thenReturn("Test");

        menu.display();
        verify(fakePrintStream, never()).println("1. Test");
    }

    @Test
    public void shouldDisplayLoginRequiredOptionIfLoggedIn() {
        Menu menu = new Menu(fakePrintStream, fakeSession);
        MenuOption mockOption = mock(MenuOption.class);
        menu.addOption(mockOption);
        when(fakeSession.userLoggedIn()).thenReturn(true);
        when(mockOption.needsLogin()).thenReturn(true);
        when(mockOption.displayIfLoggedIn()).thenReturn(true);
        when(mockOption.getName()).thenReturn("Test");

        menu.display();
        verify(fakePrintStream).println("1. Test");

    }

    @Test
    public void shouldNotDisplayNoDisplayIfLoggedInOptionIfLoggedIn() {
        Menu menu = new Menu(fakePrintStream, fakeSession);
        MenuOption mockOption = mock(MenuOption.class);
        menu.addOption(mockOption);
        when(fakeSession.userLoggedIn()).thenReturn(true);
        when(mockOption.needsLogin()).thenReturn(false);
        when(mockOption.displayIfLoggedIn()).thenReturn(false);
        when(mockOption.getName()).thenReturn("Test");

        menu.display();
        verify(fakePrintStream, never()).println("1. Test");

    }

    @Test
    public void shouldNotAllowSelectionOfUndisplayedMenuItem() {
        Menu menu = new Menu(fakePrintStream, fakeSession);
        MenuOption mockOption = mock(MenuOption.class);
        menu.addOption(mockOption);
        when(fakeSession.userLoggedIn()).thenReturn(false);
        when(mockOption.needsLogin()).thenReturn(true);

        menu.choose("1");
        verify(mockOption, never()).execute();
    }
}
