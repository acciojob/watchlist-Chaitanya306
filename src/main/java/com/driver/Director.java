package com.driver;

public class Director {
    String name;
    int noOfMovies;
    double imdbRating;

    public Director() {}

    public Director(String name, int noOfMovies, double imdbRating) {
        this.name = name;
        this.noOfMovies = noOfMovies;
        this.imdbRating = imdbRating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNoOfMovies(int noOfMovies) {
        this.noOfMovies = noOfMovies;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getName() {
        return name;
    }

    public int getNoOfMovies() {
        return noOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }
}
