// CountryRepository.java
package com.example.m_paridarshan.repository;

import com.example.m_paridarshan.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {}
