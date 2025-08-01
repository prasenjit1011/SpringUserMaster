package com.example.m_paridarshan.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CityDTO {

    private Long id;

    @NotBlank(message = "City name is required")
    @Size(min = 2, max = 50, message = "City name must be between 2 and 50 characters")
    private String name;

    private Long stateId;

    // Getters and Setters
}
