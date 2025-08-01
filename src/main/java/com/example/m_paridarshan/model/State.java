// // State.java
// package com.example.m_paridarshan.model;

// import jakarta.persistence.*;

// @Entity
// public class State {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     @ManyToOne
//     @JoinColumn(name = "country_id")
//     private Country country;

//     // Getters and Setters
// }

//--------------------
package com.example.m_paridarshan.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
