package com.example.m_paridarshan.service;

import com.example.m_paridarshan.model.Distributor;
import com.example.m_paridarshan.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistributorService {
    @Autowired
    private DistributorRepository distributorRepository;

    public Distributor saveDistributor(Distributor distributor) {
        return distributorRepository.save(distributor);
    }

    public List<Distributor> getAllDistributors() {
        return distributorRepository.findAll();
    }

    public Optional<Distributor> getDistributorById(Long id) {
        return distributorRepository.findById(id);
    }

    public void deleteDistributor(Long id) {
        distributorRepository.deleteById(id);
    }
}
