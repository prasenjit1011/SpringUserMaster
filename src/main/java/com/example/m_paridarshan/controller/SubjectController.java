package com.example.m_paridarshan.controller;

import com.example.m_paridarshan.model.Subject;
import com.example.m_paridarshan.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    // Create Subject
    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }

    // Get All Subjects
    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    // Get Subject by ID
    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable String id) {
        return subjectService.getSubjectById(id);
    }

    // Update Subject
    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable String id, @RequestBody Subject updatedSubject) {
        return subjectService.updateSubject(id, updatedSubject);
    }

    // Delete Subject
    @DeleteMapping("/{id}")
    public String deleteSubject(@PathVariable String id) {
        subjectService.deleteSubject(id);
        return "Subject deleted successfully with id: " + id;
    }
}
