package com.example.FleetFlow.service;

import com.example.FleetFlow.Models.Chauffeur;
import com.example.FleetFlow.repository.ChauffeurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChauffeurService {

    private final ChauffeurRepository chauffeurRepository;

    public Chauffeur ajouterChauffeur(Chauffeur chauffeur) {
        chauffeur.setDisponible(true);
        return chauffeurRepository.save(chauffeur);
    }

    public Chauffeur modifierChauffeur(int id, Chauffeur chauffeurDetails) {
        Chauffeur chauffeur = chauffeurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chauffeur non trouvé"));

        chauffeur.setNom(chauffeurDetails.getNom());
        chauffeur.setTelephone(chauffeurDetails.getTelephone());
        chauffeur.setPermisType(chauffeurDetails.getPermisType());

        return chauffeurRepository.save(chauffeur);
    }

    public void supprimerChauffeur(int id) {
        chauffeurRepository.deleteById(id);
    }

    public List<Chauffeur> listerChauffeursDisponibles() {
        return chauffeurRepository.findChauffeurByDisponibleTrue();
    }
}