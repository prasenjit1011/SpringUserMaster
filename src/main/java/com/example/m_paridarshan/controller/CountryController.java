package com.example.m_paridarshan.controller;

import com.example.m_paridarshan.dto.CountryDTO;
import com.example.m_paridarshan.model.Country;
import com.example.m_paridarshan.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping
    public ResponseEntity<CountryDTO> createCountry(@RequestBody CountryDTO countryDTO) {
        Country country = new Country();
        country.setName(countryDTO.getName());
        Country saved = countryService.saveCountry(country);
        return new ResponseEntity<>(toDTO(saved), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CountryDTO> getAllCountries() {
        return countryService.getAllCountries().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getCountry(@PathVariable Long id) {
        Optional<Country> country = countryService.getCountryById(id);
        return country.map(value -> ResponseEntity.ok(toDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> updateCountry(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {
        Optional<Country> optionalCountry = countryService.getCountryById(id);
        if (!optionalCountry.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Country country = optionalCountry.get();
        country.setName(countryDTO.getName());
        Country updated = countryService.saveCountry(country);
        return ResponseEntity.ok(toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.noContent().build();
    }

    private CountryDTO toDTO(Country country) {
        CountryDTO dto = new CountryDTO();
        dto.setId(country.getId());
        dto.setName(country.getName());
        return dto;
    }
}
