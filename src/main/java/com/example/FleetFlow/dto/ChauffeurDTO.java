package com.example.FleetFlow.dto;

import lombok.Data;

@Data
public class ChauffeurDTO {
    private Long id;
    private String nom;
    private String telephone;
    private String permisType;
    private Boolean disponible;
}
