package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie){
        movieRepository.addMovieToDatabase(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirectorToDatabase(director);
    }
    public void addMovieDirectorPair(String directorName,String movieName){
        movieRepository.addMovieDirectorPairToDatabase(directorName,movieName);
    }
    public Movie getMovieByName(String movieName){
        return movieRepository.getMovieByNameFromDatabase(movieName);
    }
    public Director getDirectorByName(String directorName){
        return movieRepository.getDirectorByNameFromDatabase(directorName);
    }
    public List<Movie> getMoviesByDirectorName(String directorName){
        return movieRepository.getMoviesByDirectorNameFromDatabase(directorName);
    }
    public List<Movie> findAllMovies(){
        return movieRepository.findAllMoviesFromDatabase();
    }
    public void deleteDirectorByName(String directorName){
        movieRepository.deleteDirectorByNameFromDatabase(directorName);
        return;
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectorsFromDataBase();

    }

}
