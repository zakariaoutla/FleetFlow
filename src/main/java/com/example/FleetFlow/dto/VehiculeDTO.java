package com.example.FleetFlow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class VehiculeDTO {
    @NotBlank
    private String matricule;
    @NotBlank
    private String type;
    @NotBlank
    private int capacite;
    @NotBlank
    private String status;
}
