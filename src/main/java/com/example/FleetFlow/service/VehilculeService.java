package com.example.FleetFlow.service;

import com.example.FleetFlow.Models.Vehicule;
import com.example.FleetFlow.dto.VehiculeDTO;
import com.example.FleetFlow.enums.StatutVehicule;
import com.example.FleetFlow.mapper.VehilculeMapper;
import com.example.FleetFlow.repository.LivraisonRepository;
import com.example.FleetFlow.repository.VehiculeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class VehilculeService {

    private final VehiculeRepository vehiculeRepository;
    private final VehilculeMapper vehilculeMapper;
    private final LivraisonRepository livraisonRepository;

    public VehiculeDTO save(VehiculeDTO vehicule) {
        Vehicule entity = new Vehicule();
        entity.setMatricule(vehicule.getMatricule());
        entity.setType(vehicule.getType());
        entity.setCapacite(vehicule.getCapacite());
        entity.setStatus(StatutVehicule.valueOf(String.valueOf(vehicule.getStatus())));

        Vehicule saved = vehiculeRepository.save(entity);
        return vehilculeMapper.toDTO(saved);
    }

    public void delete(long id) {
        vehiculeRepository.deleteById(id);
    }

    public VehiculeDTO update(long id, VehiculeDTO vehicule) {
        Vehicule existing = vehiculeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicule introuvable"));

        existing.setMatricule(vehicule.getMatricule());
        existing.setCapacite(vehicule.getCapacite());
        existing.setStatus(StatutVehicule.valueOf(String.valueOf(vehicule.getStatus())));
        existing.setType(vehicule.getType());

        Vehicule updated = vehiculeRepository.save(existing);
        return vehilculeMapper.toDTO(updated);
    }

    public List<VehiculeDTO> findByStatut(StatutVehicule statut) {
        return vehilculeMapper.todtolist(vehiculeRepository.findByStatus(statut));
    }

    public List<VehiculeDTO> findByCapaciteGreaterThan(int capacite) {
        return vehilculeMapper.todtolist(vehiculeRepository.findByCapaciteGreaterThan(capacite));
    }

}
