package com.example.m_paridarshan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CityDTO {
    private Long id;
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long stateId;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String stateName;
}
