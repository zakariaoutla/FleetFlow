package com.example.FleetFlow.dto;

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
    @NotBlank
    private long id;
    @NotBlank
    private String matricule;
    @NotBlank
    private String type;
    @NotBlank
    @Positive
    private int capacite;
    @NotBlank
    private String status;
    private long totalcount;
}
