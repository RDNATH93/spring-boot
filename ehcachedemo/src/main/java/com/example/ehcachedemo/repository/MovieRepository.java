package com.example.ehcachedemo.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import com.example.ehcachedemo.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MovieRepository {

    private Map<String, Movie> moviesHub = new HashMap<>();

    public void addMovie(Movie movie) {
        verySlowService();
        moviesHub.put(movie.getTitle(), movie);
    }

    public void deleteMovie(String title) {
        log.info("executing delete operation for title {}",title);
        verySlowService();
        moviesHub.remove(title);
    }

    public Movie searchMovie(String title) {
        log.info("executing search operation for title {}",title);
        verySlowService();
        return moviesHub.get(title);
    }

    private void verySlowService() {
        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
