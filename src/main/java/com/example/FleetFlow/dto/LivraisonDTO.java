package com.example.FleetFlow.dto;

import com.example.FleetFlow.enums.StatutLivraison;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LivraisonDTO {
    private Long id;
    private LocalDateTime dateLivraison;
    private String adresseDepart;
    private String adresseDestination;
    private StatutLivraison statut;

    private Long clientId;
    private Long chauffeurId;
    private Long vehiculeId;
}
