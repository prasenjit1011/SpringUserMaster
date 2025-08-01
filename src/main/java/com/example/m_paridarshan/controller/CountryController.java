package com.example.m_paridarshan.controller;

import com.example.m_paridarshan.dto.CountryDTO;
import com.example.m_paridarshan.model.Country;
import com.example.m_paridarshan.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    // @GetMapping
    // public List<CountryDTO> getAllCountries() {
    //     return countryService.getAllCountries()
    //                          .stream()
    //                          .map(country -> {
    //                              CountryDTO dto = new CountryDTO();
    //                              dto.setId(country.getId());
    //                              dto.setName(country.getName());
    //                              return dto;
    //                          })
    //                          .collect(Collectors.toList());
    // }
    


    @GetMapping
    public List<CountryDTO> getAllCountries() {
        return countryService.getAllCountries();
    }

    @PostMapping
    public ResponseEntity<Country> addCountry(@Valid @RequestBody CountryDTO countryDTO) {
        Country country = new Country();
        country.setName(countryDTO.getName());
        // Optional: Map StateDTOs to actual State entities
        Country saved = countryService.saveCountry(country);
        return ResponseEntity.ok(saved);
    }
}
