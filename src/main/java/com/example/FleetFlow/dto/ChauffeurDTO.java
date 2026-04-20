package com.example.FleetFlow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChauffeurDTO {

    private Long id;
    @NotBlank(message = "Le nom du chauffeur est obligatoire")
    private String nom;
    @NotBlank(message = "Le telephone de chauffeur est obligatoire")
    private String telephone;
    @NotBlank(message = "Le type de permis est obligatoire")
    private String permisType;
    @NotBlank(message = "Le Disponible de permis est obligatoire")
    private Boolean disponible;
}
