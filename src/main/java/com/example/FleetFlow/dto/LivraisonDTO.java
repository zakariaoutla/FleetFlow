package com.example.FleetFlow.dto;

import com.example.FleetFlow.enums.StatutLivraison;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LivraisonDTO {
    private Long id;
    @NotBlank
    private LocalDateTime dateLivraison;
    @NotBlank
    private String adresseDepart;
    @NotBlank
    private String adresseDestination;
    @NotBlank
    private StatutLivraison statut;
    @NotBlank
    private Long clientId;
    @NotBlank
    private Long chauffeurId;
    @NotBlank
    private Long vehiculeId;

}
