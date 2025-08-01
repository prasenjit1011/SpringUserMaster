// StateDTO.java
package com.example.m_paridarshan.dto;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StateDTO {
    private Long id;
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long countryId; // <-- Important for assigning to a country
    
}
