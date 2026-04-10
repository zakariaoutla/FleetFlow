package com.example.FleetFlow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChauffeurDTO {

    private Long id;
    @NotBlank
    private String nom;
    @NotBlank
    @Size(min = 10, max = 10)
    private String telephone;
    @NotBlank
    private String permisType;
    @NotBlank
    private Boolean disponible;
}
