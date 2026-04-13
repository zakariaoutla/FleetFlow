package com.example.FleetFlow.dto;

import com.example.FleetFlow.enums.StatutVehicule;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank
    private String matricule;

    @NotBlank
    private String type;

    @Positive
    private int capacite;

    @NotNull
    private StatutVehicule status;

    private long totalcount;
}
