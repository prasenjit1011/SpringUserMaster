package com.example.m_paridarshan.controller;

import com.example.m_paridarshan.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/employee")
    public Map<String, Object> getEmployee() {
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "Ravi");
        emp.put("designation", "Tester");
        emp.put("salary", 100);
        emp.put("time", LocalDateTime.now().toString());
        return emp;
    }

    @GetMapping("/empdata")
    public Map<String, String> login() {
        // Get employee data as a Map
        Map<String, Object> employeeData = getEmployee();
    
        // Generate JWT token with employee claims
        String token = JwtUtil.generateToken(employeeData);
    
        // Return token as JSON
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return response;
    }


    @PostMapping("/login")
    public Map<String, String> login(@RequestParam String username, @RequestParam String password) {
        // In real apps, verify username & password from DB
        if ("admin".equals(username) && "password".equals(password)) {
            String token = JwtUtil.generateUserToken(username);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return response;
        }
        throw new RuntimeException("Invalid credentials");
    }
}
