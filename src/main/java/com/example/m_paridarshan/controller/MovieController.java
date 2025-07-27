package com.example.m_paridarshan.controller;

import com.example.m_paridarshan.model.Movie;
import com.example.m_paridarshan.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @GetMapping
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable String id) {
        return movieRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable String id, @RequestBody Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        movieRepository.deleteById(id);
    }
}
