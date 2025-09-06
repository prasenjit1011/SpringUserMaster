package com.example.m_paridarshan.model;

import jakarta.persistence.*;

@Entity
public class TouristSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }
}
