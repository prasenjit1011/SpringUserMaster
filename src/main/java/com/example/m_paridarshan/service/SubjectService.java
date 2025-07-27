package com.example.m_paridarshan.service;

import com.example.m_paridarshan.model.Subject;
import com.example.m_paridarshan.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    // Create
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    // Read All
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    // Read One
    public Subject getSubjectById(String id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));
    }

    // Update
    public Subject updateSubject(String id, Subject updatedSubject) {
        Optional<Subject> existingOptional = subjectRepository.findById(id);
        if (existingOptional.isPresent()) {
            Subject existing = existingOptional.get();
            existing.setName(updatedSubject.getName());
            existing.setDescription(updatedSubject.getDescription());
            return subjectRepository.save(existing);
        } else {
            throw new RuntimeException("Subject not found with id: " + id);
        }
    }

    // Delete
    public void deleteSubject(String id) {
        if (!subjectRepository.existsById(id)) {
            throw new RuntimeException("Subject not found with id: " + id);
        }
        subjectRepository.deleteById(id);
    }
}
