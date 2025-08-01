// CountryService.java
package com.example.m_paridarshan.service;

import com.example.m_paridarshan.dto.CountryDTO;
import com.example.m_paridarshan.dto.StateDTO;
import com.example.m_paridarshan.model.Country;
import com.example.m_paridarshan.model.State;
import com.example.m_paridarshan.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
    private final CountryRepository countryRepo;

    public CountryService(CountryRepository countryRepo) {
        this.countryRepo = countryRepo;
    }

    public List<CountryDTO> getAllCountries() {
        return countryRepo.findAll().stream().map(country -> {
            CountryDTO dto = new CountryDTO();
            dto.setId(country.getId());
            dto.setName(country.getName());
            dto.setStates(country.getStates().stream().map(state -> {
                StateDTO sd = new StateDTO();
                sd.setId(state.getId());
                sd.setName(state.getName());
                return sd;
            }).collect(Collectors.toList()));
            return dto;
        }).collect(Collectors.toList());
    }


    public CountryDTO createCountry(CountryDTO countryDTO) {
        Country country = new Country();
        country.setName(countryDTO.getName());
    
        // Convert StateDTOs to State entities
        if (countryDTO.getStates() != null) {
            List<State> states = countryDTO.getStates().stream().map(stateDTO -> {
                State state = new State();
                state.setName(stateDTO.getName());
                state.setCountry(country); // set the parent relationship
                return state;
            }).collect(Collectors.toList());
            country.setStates(states);
        }
    
        Country saved = countryRepo.save(country);
    
        // Convert back to CountryDTO
        CountryDTO savedDTO = new CountryDTO();
        savedDTO.setId(saved.getId());
        savedDTO.setName(saved.getName());
        if (saved.getStates() != null) {
            List<StateDTO> savedStates = saved.getStates().stream().map(state -> {
                StateDTO sd = new StateDTO();
                sd.setId(state.getId());
                sd.setName(state.getName());
                return sd;
            }).collect(Collectors.toList());
            savedDTO.setStates(savedStates);
        }
    
        return savedDTO;
    }
    

    public void deleteCountry(Long id) {
        if (!countryRepo.existsById(id)) {
            throw new RuntimeException("Country not found with ID: " + id);
        }
        countryRepo.deleteById(id);
    }
    


}
