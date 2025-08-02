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
import java.util.UUID;

@Entity
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = true)
    private String imageName;


    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<State> states;

    @PrePersist
    public void prePersist() {
        if (this.imageName == null || this.imageName.isBlank()) {
            this.imageName = "country_" + UUID.randomUUID().toString().substring(0, 8);
        }
    }

}
