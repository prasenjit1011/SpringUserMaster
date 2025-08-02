package com.example.m_paridarshan.service;

import com.example.m_paridarshan.dto.CityDTO;
import com.example.m_paridarshan.dto.CountryDTO;
import com.example.m_paridarshan.dto.StateDTO;
import com.example.m_paridarshan.model.Country;
import com.example.m_paridarshan.model.State;
import com.example.m_paridarshan.repository.CountryRepository;
import com.example.m_paridarshan.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateService {

    private final StateRepository stateRepository;
    private final CountryRepository countryRepository;

    public StateService(StateRepository stateRepository, CountryRepository countryRepository) {
        this.stateRepository = stateRepository;
        this.countryRepository = countryRepository;
    }

    // ✅ Get all states
    public List<StateDTO> getAllStates() {
        return stateRepository.findAll()
                .stream()
                .map(state-> {
                    StateDTO dto = new StateDTO();
                    dto.setId(state.getId()*10000);
                    dto.setName(state.getName());
                    if (state.getCountry() != null) {
                        dto.setCountryId(state.getCountry().getId());
                    }


                    dto.setCities(state.getCities().stream().map(city -> {
                        CityDTO cityDto = new CityDTO(); // ✅ Use correct DTO
                        cityDto.setId(city.getId() * 10000);
                        cityDto.setName(city.getName());
                        return cityDto;
                    }).collect(Collectors.toList()));
                    

                    return dto;
                })                
                .collect(Collectors.toList());
    }




    public List<StateDTO> getAllStatesOld() {
        return stateRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // ✅ Get state by ID
    public StateDTO getStateById(Long id) {
        State state = stateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("State not found with ID: " + id));
        return convertToDTO(state);
    }

    // ✅ Create new state
    public StateDTO createState(StateDTO stateDTO) {
        State state = new State();
        state.setName(stateDTO.getName());

        if (stateDTO.getCountryId() != null) {
            Country country = countryRepository.findById(stateDTO.getCountryId())
                    .orElseThrow(() -> new RuntimeException("Country not found with ID: " + stateDTO.getCountryId()));
            state.setCountry(country);
        }

        State saved = stateRepository.save(state);
        return convertToDTO(saved);
    }

    // ✅ Update state
    public StateDTO updateState(Long id, StateDTO stateDTO) {
        State state = stateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("State not found with ID: " + id));

        state.setName(stateDTO.getName());

        if (stateDTO.getCountryId() != null) {
            Country country = countryRepository.findById(stateDTO.getCountryId())
                    .orElseThrow(() -> new RuntimeException("Country not found with ID: " + stateDTO.getCountryId()));
            state.setCountry(country);
        }

        State updated = stateRepository.save(state);
        return convertToDTO(updated);
    }

    // ✅ Delete state
    public void deleteState(Long id) {
        if (!stateRepository.existsById(id)) {
            throw new RuntimeException("State not found with ID: " + id);
        }
        stateRepository.deleteById(id);
    }

    // ✅ Convert State to StateDTO
    private StateDTO convertToDTO(State state) {
        StateDTO dto = new StateDTO();
        dto.setId(state.getId());
        dto.setName(state.getName());
        if (state.getCountry() != null) {
            dto.setCountryId(state.getCountry().getId());
        }
        return dto;
    }
}
