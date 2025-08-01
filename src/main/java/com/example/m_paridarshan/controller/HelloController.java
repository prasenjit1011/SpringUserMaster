package com.example.m_paridarshan.controller;

import org.springframework.boot.SpringBootVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HelloController {
    @GetMapping("/")
    public Map<String, Object> hello() {
        return Map.of(
            "Spring Boot Version", SpringBootVersion.getVersion(),
            "msg", "Hello World : Pom.xml, DB Connected Successfully. Product Crud Initialized for product add and listing.", 
            "status", 200
        );
    }
}
