package com.thoughtworks.biblioteca;

public abstract class Media {
    private boolean isCheckedOut = false;
    public void checkOut() {
        isCheckedOut = true;
    }

    public void checkIn() {
        isCheckedOut = false;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public abstract String getDetails();
}
