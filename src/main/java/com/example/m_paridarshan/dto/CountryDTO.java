// package com.example.m_paridarshan.dto;

// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;
// import lombok.Data;

// import java.util.List;

// @Data
// public class CountryDTO {

//     private Long id;

//     @NotBlank(message = "Country name is required")
//     @Size(min = 3, max = 50, message = "Country name must be between 3 and 50 characters")
//     private String name;

//     private List<StateDTO> states;
// }




package com.example.m_paridarshan.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

public class CountryDTO {

    private Long id;

    @NotBlank(message = "Country name is required")
    @Size(min = 3, max = 50, message = "Country name must be between 3 and 50 characters")
    private String name;

    private List<StateDTO> states;

    // ✅ Getter
    public Long getId() {
        return id;
    }

    // ✅ Setter
    public void setId(Long id) {
        this.id = id;
    }

    // ✅ Getter
    public String getName() {
        return name;
    }

    // ✅ Setter
    public void setName(String name) {
        this.name = name;
    }

    public List<StateDTO> getStates() {
        return states;
    }

    public void setStates(List<StateDTO> states) {
        this.states = states;
    }
}


// package com.example.m_paridarshan.dto;

// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;
// import java.util.List;

// public class CountryDTO {
    
//     private Long id;

//     @NotBlank(message = "Country name is required")
//     @Size(min = 3, max = 50, message = "Country name must be between 3 and 50 characters")
//     private String name;

//     private List<StateDTO> states;

//     // Getters and Setters
// }
