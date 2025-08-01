// // Country.java
// package com.example.m_paridarshan.model;

// import jakarta.persistence.*;
// import java.util.List;

// @Entity
// public class Country {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<State> states;

//     // Getters and Setters
// }


//=================================
package com.example.m_paridarshan.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<State> states;
}
