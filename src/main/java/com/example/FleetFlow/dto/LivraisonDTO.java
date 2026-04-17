package com.example.FleetFlow.dto;

import com.example.FleetFlow.enums.StatutLivraison;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LivraisonDTO {
    private Long id;
    @NotNull(message = "La date de livraison est obligatoire")
    @FutureOrPresent(message = "La date ne peut pas être dans le passé")
    private LocalDateTime dateLivraison;
    @NotBlank(message = "L'adresse de départ est requise")
    private String adresseDepart;
    @NotBlank(message = "L'adresse de destination est requise")
    private String adresseDestination;
    @NotNull(message = "La status de livraison est obligatoire")
    private StatutLivraison statut;
    @NotNull(message = "L'ID du client est obligatoire")
    @Positive(message = "L'ID du client doit être valide")
    private Long clientId;
    @NotNull(message = "L'ID du chauffeur est obligatoire")
    @Positive(message = "L'ID du chauffeur doit être valide")
    private Long chauffeurId;
    @NotNull(message = "L'ID du véhicule est obligatoire")
    @Positive(message = "L'ID du véhicule doit être valide")
    private Long vehiculeId;

}
