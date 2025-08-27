package com.example.m_paridarshan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public Map<String, Object> hello() {
        return Map.of("msg", "Hello World", "status", 200);
    }

    @GetMapping("/tables")
    public List<String> listTables() {
        String sql = """
            SELECT table_name 
            FROM information_schema.tables 
            WHERE table_schema='public' 
            ORDER BY table_name;
        """;

        return jdbcTemplate.queryForList(sql, String.class);
    }

    @GetMapping("/tables/{tableName}")
    public List<Map<String, Object>> getTableData(@PathVariable String tableName) {
        String sql = "SELECT * FROM " + tableName + " LIMIT 50"; // limit to avoid huge data
        return jdbcTemplate.queryForList(sql);
    }
}

