package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired MovieService movieService;

    @PostMapping("/add-movie")
    ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName")String movieName,
                                                @RequestParam("directorName")String directorName){
        movieService.addMovieDirectorPair(directorName,movieName);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/get-movie-by-name/{name}")
    ResponseEntity<Movie> getMovieByName(@PathVariable("name")String movieName){
        Movie m=movieService.getMovieByName(movieName);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    ResponseEntity<Director> getDirectorByName(@PathVariable("name")String directorName){
        Director d=movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(d,HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathVariable("director")String directorName){
        List<Movie> moviesBydirectorsName=movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(moviesBydirectorsName,HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    ResponseEntity<List<Movie>> findAllMovies(){
        List<Movie> allMovies=movieService.findAllMovies();
        return new ResponseEntity<>(allMovies,HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName")String directorName){
        movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    @DeleteMapping("/delete-director-by-name")
    ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
