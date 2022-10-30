package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    void addMovie(Movie movie){
        movieRepository.addMovieToDatabase(movie);
    }
    void addDirector(Director director){
        movieRepository.addDirectorToDatabase(director);
    }
    void addMovieDirectorPair(String directorName,String movieName){
        movieRepository.addMovieDirectorPairToDatabase(directorName,movieName);
    }
    Movie getMovieByName(String movieName){
        return movieRepository.getMovieByNameFromDatabase(movieName);
    }
    Director getDirectorByName(String directorName){
        return movieRepository.getDirectorByNameFromDatabase(directorName);
    }
    List<Movie> getMoviesByDirectorName(String directorName){
        return movieRepository.getMoviesByDirectorNameFromDatabase(directorName);
    }
    List<Movie> findAllMovies(){
        return movieRepository.findAllMoviesFromDatabase();
    }
    void deleteDirectorByName(String directorName){
        movieRepository.deleteDirectorByNameFromDatabase(directorName);
        return;
    }

    void deleteAllDirectors(){
        movieRepository.deleteAllDirectorsFromDataBase();

    }

}
