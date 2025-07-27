package com.example.m_paridarshan.repository;

import com.example.m_paridarshan.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
    // Custom queries can be added here
}
