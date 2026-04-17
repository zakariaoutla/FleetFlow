package com.example.FleetFlow.Models;

import com.example.FleetFlow.enums.StatutLivraison;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "livraison")
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_livraison")
    @Temporal(TemporalType.DATE)
    private LocalDate dateLivraison;
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
    @JoinColumn(name = "client_id" , nullable = false)
    private Client client;
}
