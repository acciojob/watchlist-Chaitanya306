package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Component
public class MovieRepository {
    List<Movie> movies=new ArrayList<>();
    List<Director> directors=new ArrayList<>();
    HashMap<Director,List<Movie>> directorMoviePair=new HashMap<>();

    public void addMovieToDatabase(Movie movie){
        movies.add(movie);
    }
    public void addDirectorToDatabase(Director director){
        directors.add(director);
    }
    public void addMovieDirectorPairToDatabase(String directorName,String movieName){
        Director director=null;
        Movie movie=null;
        for(Director d:directors){
            if(directorName==d.getName()){  director=d; }
        }
        for(Movie m:movies){
            if(movieName==m.getName()){  movie=m; }
        }
        if(directorMoviePair.containsKey(director)){
            directorMoviePair.get(director).add(movie);
        }
        else{
            List<Movie> list=new ArrayList<>();
            list.add(movie);
            directorMoviePair.put(director,list);
        }
    }
    public Movie getMovieByNameFromDatabase(String movieName){
        for(Movie m:movies){
            if(m.getName().equals(movieName)) return m;
        }
        return null;
    }

    public Director getDirectorByNameFromDatabase(String directorName){
        for(Director d:directors){
            if(d.getName().equals(directorName)){ return d; }
        }
        return null;
    }
    public List<Movie> getMoviesByDirectorNameFromDatabase(String directorName){
        for(Director d:directorMoviePair.keySet()){
            if(d.getName().equals(directorName)){ return directorMoviePair.get(d); }
        }
        return null;
    }
    public List<Movie> findAllMoviesFromDatabase(){
        return movies;
    }
    public void deleteDirectorByNameFromDatabase(String directorName){
        Director director=null;
        for(Director d:directors){
            if(d.getName().equals(directorName)){  director=d; }
        }
        for(Movie m:directorMoviePair.get(director)){
            movies.remove(m);
        }
        directors.remove(director);
        directorMoviePair.remove(director);
    }

    public void deleteAllDirectorsFromDataBase(){
        movies=new ArrayList<>();
        directors=new ArrayList<>();
        directorMoviePair=new HashMap<>();
    }

}
