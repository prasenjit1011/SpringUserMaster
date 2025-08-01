// controller/ProductController.java
package com.example.m_paridarshan.controller;

import com.example.m_paridarshan.dto.ProductDTO;
import com.example.m_paridarshan.model.Product;
import com.example.m_paridarshan.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductDTO dto) {
        return ResponseEntity.ok(service.addProduct(dto));
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }
}
