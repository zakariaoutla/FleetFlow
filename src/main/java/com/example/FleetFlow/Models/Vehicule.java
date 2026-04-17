package com.example.FleetFlow.Models;

import com.example.FleetFlow.enums.StatutVehicule;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
@Entity
@Table(name = "vehicule")
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String matricule;
    private String type;
    private int capacite;
    @Enumerated(EnumType.STRING)
    private StatutVehicule status;



}
