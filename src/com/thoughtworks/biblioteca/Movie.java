package com.thoughtworks.biblioteca;

public class Movie extends Media {
    private final String name;
    private final String year;
    private final String director;
    private final int rating;

    public Movie(String name, String year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getDetails() {
        String nameToPrint = shortenTextIfNecessary(name);
        String directorToPrint = shortenTextIfNecessary(director);

        String ratingToPrint;
        if (rating == 0) {
            ratingToPrint = "unrated";
        } else {
            ratingToPrint = Integer.toString(rating);
        }

        return String.format("%-30s %-30s %-4s %8s", nameToPrint, directorToPrint, year, ratingToPrint);
    }

    private String shortenTextIfNecessary(String text) {
        if (text.length() > 30) {
            return text.substring(0, 27) + "...";
        } else {
            return text;
        }
    }
}
