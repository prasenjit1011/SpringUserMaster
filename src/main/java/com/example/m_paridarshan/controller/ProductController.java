// controller/ProductController.java
package com.example.m_paridarshan.controller;

import com.example.m_paridarshan.dto.ProductDTO;
import com.example.m_paridarshan.model.Product;
import com.example.m_paridarshan.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Map;
import java.util.HashMap;



import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;
    private final JdbcTemplate jdbcTemplate;

    public ProductController(ProductService service, JdbcTemplate jdbcTemplate) {
        this.service = service;
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductDTO dto) {
        return ResponseEntity.ok(service.addProduct(dto));
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> listProductsWithConnectionId() {
        // Fetch PostgreSQL backend process ID (connection ID)
        Integer connectionId = jdbcTemplate.queryForObject("SELECT pg_backend_pid()", Integer.class);

        Map<String, Object> response = new HashMap<>();
        response.put("dbConnectionID", connectionId);
        response.put("productlist", service.getAllProducts());
        return ResponseEntity.ok(response);
    }

}
