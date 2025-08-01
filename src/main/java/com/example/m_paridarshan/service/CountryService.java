package com.example.m_paridarshan.service;

import com.example.m_paridarshan.model.Country;
import com.example.m_paridarshan.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryRepository countryRepo;

    public CountryService(CountryRepository countryRepo) {
        this.countryRepo = countryRepo;
    }

    public List<Country> getAllCountries() {
        return countryRepo.findAll();
    }

    public Country saveCountry(Country country) {
        return countryRepo.save(country);
    }
}
