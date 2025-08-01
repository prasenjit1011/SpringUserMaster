package com.example.m_paridarshan.service;

import com.example.m_paridarshan.dto.CityDTO;
import com.example.m_paridarshan.model.City;
import com.example.m_paridarshan.model.State;
import com.example.m_paridarshan.repository.CityRepository;
import com.example.m_paridarshan.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepo;
    private final StateRepository stateRepo;

    public CityService(CityRepository cityRepo, StateRepository stateRepo) {
        this.cityRepo = cityRepo;
        this.stateRepo = stateRepo;
    }

    public List<CityDTO> getAllCities() {
        return cityRepo.findAll().stream().map(city -> {
            CityDTO dto = new CityDTO();
            dto.setId(city.getId());
            dto.setName(city.getName());
            dto.setStateId(city.getState().getId());
            dto.setStateName(city.getState().getName());
            return dto;
        }).collect(Collectors.toList());
    }

    public CityDTO createCity(CityDTO cityDTO) {
        State state = stateRepo.findById(cityDTO.getStateId())
                .orElseThrow(() -> new RuntimeException("State not found"));

        City city = new City();
        city.setName(cityDTO.getName());
        city.setState(state);
        City saved = cityRepo.save(city);

        cityDTO.setId(saved.getId());
        cityDTO.setStateName(state.getName());
        return cityDTO;
    }
}
