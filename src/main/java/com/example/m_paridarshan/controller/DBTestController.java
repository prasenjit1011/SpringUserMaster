package com.example.m_paridarshan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@RestController
@RequestMapping("/db")
public class DBTestController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/test")
    public String testDbConnection() {
        try (Connection connection = dataSource.getConnection()) {
            return "Connected to: " + connection.getMetaData().getURL();
        } catch (SQLException e) {
            return "DB Connection failed: " + e.getMessage();
        }
    }
}
