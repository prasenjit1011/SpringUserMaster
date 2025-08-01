package com.example.m_paridarshan.service;

import com.example.m_paridarshan.dto.CountryDTO;
import com.example.m_paridarshan.model.Country;
import com.example.m_paridarshan.repository.CountryRepository;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;


import java.util.List;

@Service
public class CountryService {
    private final CountryRepository countryRepo;

    public CountryService(CountryRepository countryRepo) {
        this.countryRepo = countryRepo;
    }

    // public List<Country> getAllCountries() {
    //     return countryRepo.findAll();
    // }

    // public List<CountryDTO> getAllCountries() {
    //     return countryRepo.findAll().stream()
    //         .map(country -> new CountryDTO(country.getId(), country.getName()))
    //         .collect(Collectors.toList());
    // }


    public List<CountryDTO> getAllCountries() {
        return countryRepo.findAll().stream()
            .map(country -> new CountryDTO(country.getId(), country.getName(), null)) // Assuming states are not needed here
            .collect(Collectors.toList());
    }

    public Country saveCountry(Country country) {
        return countryRepo.save(country);
    }
}
