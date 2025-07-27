package com.example.m_paridarshan.repository;

import com.example.m_paridarshan.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {}
