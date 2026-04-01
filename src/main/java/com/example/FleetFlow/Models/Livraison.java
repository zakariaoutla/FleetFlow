package com.example.FleetFlow.Models;

import com.example.FleetFlow.enums.StatutLivraison;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "livraisons")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime dateLivraison;
    private String adresseDepart;
    private String adressseDestination;

    @Enumerated(EnumType.STRING)
    private StatutLivraison statut;

    @ManyToOne
    @JoinColumn(name = "chauffeur_id")
    private Chauffeur chauffeur;

    @ManyToOne
    @JoinColumn(name = "vehicules_id")
    private Vehicule vehicule;

    @ManyToOne
    @JoinColumn(name = "clients_id" , nullable = false)
    private Client client;
}
