// repository/ProductRepository.java
package com.example.m_paridarshan.repository;

import com.example.m_paridarshan.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
}
