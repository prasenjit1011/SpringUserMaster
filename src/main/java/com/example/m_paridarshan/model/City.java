package com.example.m_paridarshan.model;

import jakarta.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private State state;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<TouristSpot> touristSpots = new java.util.ArrayList<>();

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public State getState() { return state; }
    public void setState(State state) { this.state = state; }
    public java.util.List<TouristSpot> getTouristSpots() { return touristSpots; }
    public void setTouristSpots(java.util.List<TouristSpot> touristSpots) { this.touristSpots = touristSpots; }
}
