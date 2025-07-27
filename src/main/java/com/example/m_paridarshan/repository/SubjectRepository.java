package com.example.m_paridarshan.repository;

import com.example.m_paridarshan.model.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepository extends MongoRepository<Subject, String> {}
