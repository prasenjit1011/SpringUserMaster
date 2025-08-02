package com.example.m_paridarshan.controller;

import com.example.m_paridarshan.dto.CountryDTO;
import com.example.m_paridarshan.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<CountryDTO> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }

    @PostMapping
    public ResponseEntity<CountryDTO> createCountry(@RequestBody CountryDTO countryDTO) {
        return ResponseEntity.ok(countryService.createCountry(countryDTO));
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<CountryDTO> updateCountry(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {
    //     return ResponseEntity.ok(countryService.updateCountry(id, countryDTO));
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.noContent().build();
    }
}



// // CountryController.java
// package com.example.m_paridarshan.controller;

// import com.example.m_paridarshan.dto.CountryDTO;
// import com.example.m_paridarshan.service.CountryService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/countries")
// public class CountryController {

//     private final CountryService countryService;

//     public CountryController(CountryService countryService) {
//         this.countryService = countryService;
//     }

//     @GetMapping
//     public List<CountryDTO> getAllCountries() {
//         return countryService.getAllCountries();
//     }
// }
