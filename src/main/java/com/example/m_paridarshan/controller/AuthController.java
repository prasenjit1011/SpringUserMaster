package com.example.m_paridarshan.controller;

import com.example.m_paridarshan.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public Map<String, String> login() {
        // In real apps, verify username & password from DB
        String token = JwtUtil.generateToken("testuser");
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return response;
    }


    @PostMapping("/login")
    public Map<String, String> login(@RequestParam String username, @RequestParam String password) {
        // In real apps, verify username & password from DB
        if ("admin".equals(username) && "password".equals(password)) {
            String token = JwtUtil.generateToken(username);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return response;
        }
        throw new RuntimeException("Invalid credentials");
    }
}
