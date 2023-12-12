package com.example.ehcachedemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ehcachedemo.entity.Movie;
import com.example.ehcachedemo.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/movies/")
public class MovieController {

    private final MovieService movieService;

    MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("add")
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie ){
        log.info("Add movie {}", movie.toString());
        movieService.saveMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @DeleteMapping("delete")
    public String removeMovie(@RequestParam(name = "title") String title) {
        log.info("Delete movie {}", title);
        movieService.deleteMovie(title);
        log.info("{} deleted", title);
        return "Deleted movie - " + title;
    }

    @GetMapping("search")
    public ResponseEntity<Movie> searchMovie(@RequestParam(name = "title") String title) {
        log.info("Get movie {}", title);
        var movie = movieService.searchMovie(title);
        log.info(movie.toString());
        return ResponseEntity.ok(movie);
    }

}
