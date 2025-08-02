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
//import lombok.Data;
import lombok.*;
import java.util.List;




@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;


    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;
}

