package com.example.FleetFlow.Models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "chauffeurs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chauffeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String telephone;
    private String permisType;
    private Boolean disponible;

    @OneToMany(mappedBy = "chauffeur")
    private List<Livraison> livraisons;
}
