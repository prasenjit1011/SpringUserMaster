package com.example.m_paridarshan.controller;

import com.example.m_paridarshan.dto.StateDTO;
import com.example.m_paridarshan.service.StateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    // GET: /states
    @GetMapping
    public List<StateDTO> getAllStates() {
        return stateService.getAllStates();
    }

    // GET: /states/{id}
    @GetMapping("/{id}")
    public ResponseEntity<StateDTO> getStateById(@PathVariable Long id) {
        return ResponseEntity.ok(stateService.getStateById(id));
    }

    // POST: /states
    @PostMapping
    public ResponseEntity<StateDTO> createState(@RequestBody StateDTO stateDTO) {
        return ResponseEntity.ok(stateService.createState(stateDTO));
    }

    // PUT: /states/{id}
    @PutMapping("/{id}")
    public ResponseEntity<StateDTO> updateState(@PathVariable Long id, @RequestBody StateDTO stateDTO) {
        return ResponseEntity.ok(stateService.updateState(id, stateDTO));
    }

    // DELETE: /states/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteState(@PathVariable Long id) {
        stateService.deleteState(id);
        return ResponseEntity.noContent().build();
    }
}
