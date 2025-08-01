package com.example.m_paridarshan.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StateDTO {

    private Long id;

    @NotBlank(message = "State name is required")
    @Size(min = 3, max = 50, message = "State name must be between 3 and 50 characters")
    private String name;
}



// package com.example.m_paridarshan.dto;

// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;
// import java.util.List;

// public class StateDTO {

//     private Long id;

//     @NotBlank(message = "State name is required")
//     @Size(min = 3, max = 50, message = "State name must be between 3 and 50 characters")
//     private String name;

//     private Long countryId;

//     private List<CityDTO> cities;

//     // Getters and Setters
// }
