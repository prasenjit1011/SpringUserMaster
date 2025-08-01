package com.example.m_paridarshan.model;

import jakarta.persistence.*;
import java.util.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<State> states = new ArrayList<>();

    // Getters and setters
    // Add this setter method
    public void setName(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }
}
