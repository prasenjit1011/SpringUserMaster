// service/ProductService.java
package com.example.m_paridarshan.service;

import com.example.m_paridarshan.dto.ProductDTO;
import com.example.m_paridarshan.model.Product;
import com.example.m_paridarshan.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Product addProduct(ProductDTO dto) {
        if (repo.findByName(dto.getName()).isPresent()) {
            throw new IllegalArgumentException("Product name must be unique");
        }

        Product product = Product.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .build();

        return repo.save(product);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }
}
