package com.example.FleetFlow.service;

import com.example.FleetFlow.Models.Chauffeur;
import com.example.FleetFlow.Models.Livraison;
import com.example.FleetFlow.Models.Vehicule;
import com.example.FleetFlow.enums.StatutLivraison;
import com.example.FleetFlow.enums.StatutVehicule;
import com.example.FleetFlow.repository.ChauffeurRepository;
import com.example.FleetFlow.repository.LivraisonRepository;
import com.example.FleetFlow.repository.VehiculeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivraisonService {

    private final LivraisonRepository livraisonRepository;
    private final ChauffeurRepository chauffeurRepository;
    private final VehiculeRepository vehiculeRepository;

    public Livraison creerLivraison(Livraison livraison) {
        livraison.setStatut(StatutLivraison.EN_ATTENTE);
        return livraisonRepository.save(livraison);
    }

    @Transactional
    public Livraison assignerChauffeurEtVehicule(int livraisonId, int chauffeurId, Long vehiculeId) {
        Livraison livraison = livraisonRepository.findById(livraisonId)
                .orElseThrow(() -> new RuntimeException("Livraison introuvable"));

        Chauffeur chauffeur = chauffeurRepository.findById(chauffeurId)
                .orElseThrow(() -> new RuntimeException("Chauffeur introuvable"));

        Vehicule vehicule = vehiculeRepository.findById(vehiculeId)
                .orElseThrow(() -> new RuntimeException("Véhicule introuvable"));

        if (!chauffeur.getDisponible()) {
            throw new RuntimeException("Le chauffeur sélectionné n'est pas disponible.");
        }
        if (vehicule.getStatus().equals(String.valueOf(StatutVehicule.DISPONIBLE))) {
            throw new RuntimeException("Le véhicule sélectionné n'est pas disponible.");
        }

        livraison.setChauffeur(chauffeur);
        livraison.setVehicule(vehicule);
        livraison.setStatut(StatutLivraison.EN_COURS);

        chauffeur.setDisponible(false);
        vehicule.setStatus(String.valueOf(StatutVehicule.EN_LIVRAISON));

        chauffeurRepository.save(chauffeur);
        vehiculeRepository.save(vehicule);

        return livraisonRepository.save(livraison);
    }

    public Livraison modifierStatutLivraison(int id, StatutLivraison nouveauStatut) {
        Livraison livraison = livraisonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livraison introuvable"));

        livraison.setStatut(nouveauStatut);

        if (nouveauStatut == StatutLivraison.LIVREE) {
            if (livraison.getChauffeur() != null) {
                livraison.getChauffeur().setDisponible(true);
                chauffeurRepository.save(livraison.getChauffeur());
            }
            if (livraison.getVehicule() != null) {
                livraison.getVehicule().setStatus(String.valueOf(StatutVehicule.DISPONIBLE));
                vehiculeRepository.save(livraison.getVehicule());
            }
        }

        return livraisonRepository.save(livraison);
    }

    public List<Livraison> listerToutesLesLivraisons() {
        return livraisonRepository.findAll();
    }
}