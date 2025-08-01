package com.example.m_paridarshan.controller;

import com.example.m_paridarshan.dto.CityDTO;
import com.example.m_paridarshan.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<CityDTO> getAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping
    public CityDTO createCity(@RequestBody CityDTO dto) {
        return cityService.createCity(dto);
    }
}
