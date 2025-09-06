package com.example.m_paridarshan.model;

import jakarta.persistence.*;

@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    private String name;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<City> cities = new java.util.ArrayList<>();

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public java.util.List<City> getCities() { return cities; }
    public void setCities(java.util.List<City> cities) { this.cities = cities; }
}
