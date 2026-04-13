package com.example.FleetFlow.dto;

import com.example.FleetFlow.enums.StatutLivraison;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LivraisonDTO {
    private Long id;

    @NotNull
    private LocalDateTime dateLivraison;

    @NotBlank
    private String adresseDepart;

    @NotBlank
    private String adresseDestination;

    @NotNull
    private StatutLivraison statut;

    @NotNull
    private Long clientId;

    @NotNull
    private Long chauffeurId;

    @NotNull
    private Long vehiculeId;

}
