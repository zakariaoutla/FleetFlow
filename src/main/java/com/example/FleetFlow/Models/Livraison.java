package com.example.FleetFlow.Models;

import com.example.FleetFlow.enums.StatutLivraison;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "livraison")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "dateLivraison")
    private LocalDateTime dateLivraison;
    @Column(name = "adresseDepart")
    private String adresseDepart;
    @Column(name = "adresseDestination")
    private String adresseDestination;

    @Enumerated(EnumType.STRING)
    private StatutLivraison statut;

    @ManyToOne
    @JoinColumn(name = "chauffeur_id")
    private Chauffeur chauffeur;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
