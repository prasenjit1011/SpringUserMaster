// StateDTO.java
package com.example.m_paridarshan.dto;

import lombok.Data;

@Data
public class StateDTO {
    private Long id;
    private String name;
    private Long countryId; // <-- Important for assigning to a country
    
}
