// CountryDTO.java
package com.example.m_paridarshan.dto;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.util.List;

@Data
public class CountryDTO {
    private Long id;

    @NotBlank(message = "Country name is required")
    @Size(min = 3, max = 50)
    private String name;

    private String imageName;

    private List<StateDTO> states;
}
