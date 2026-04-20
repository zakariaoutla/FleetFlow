package com.example.FleetFlow.dto;

import com.example.FleetFlow.enums.StatutVehicule;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class VehiculeDTO {
    private long id;
    @NotBlank(message = "Le matricule est obligatoire")
    private String matricule;
    @NotBlank(message = "Le type de vehicule est obligatoire")
    private String type;
    @Positive(message = "La capacite doit etre strictement positive")
    private int capacite;
    @NotBlank(message = "Le status est obligatoire")
    private StatutVehicule status;

    public VehiculeDTO(String matricule, String type, int capacite, StatutVehicule status){
        this.matricule = matricule;
        this.type = type;
        this.capacite= capacite;
        this.status = status;
    }
}
