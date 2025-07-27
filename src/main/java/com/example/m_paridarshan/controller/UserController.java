package com.example.m_paridarshan.controller;

import com.example.m_paridarshan.model.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private Map<String, User> users = new HashMap<>();

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        users.put(id, user);
        return user;
    }

    @GetMapping
    public Collection<User> getAllUsers() {
        return users.values();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return users.get(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @Valid @RequestBody User updatedUser) {
        User existing = users.get(id);
        if (existing != null) {
            existing.setName(updatedUser.getName());
            existing.setEmail(updatedUser.getEmail());
        }
        return existing;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        users.remove(id);
        return "User deleted successfully";
    }
}
