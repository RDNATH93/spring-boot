package com.example.ehcachedemo.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.ehcachedemo.entity.Movie;
import com.example.ehcachedemo.repository.MovieRepository;

@Service
@CacheConfig(cacheNames = { "movies" })
public class MovieService {

    private final MovieRepository repository;

    MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public void saveMovie(Movie movie) {
        repository.addMovie(movie);
    }

    @CacheEvict(key = "#p0")
    public void deleteMovie(String title) {

        repository.deleteMovie(title);

    }

    @Cacheable(key = "#p0")
    public Movie searchMovie(String title) {
        return repository.searchMovie(title);
    }

}
