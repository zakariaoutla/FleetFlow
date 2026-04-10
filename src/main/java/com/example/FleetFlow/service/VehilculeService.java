package com.example.FleetFlow.service;


import com.example.FleetFlow.Models.Vehicule;
import com.example.FleetFlow.dto.VehiculeDTO;
import com.example.FleetFlow.mapper.VehilculeMapper;
import com.example.FleetFlow.repository.LivraisonRepository;
import com.example.FleetFlow.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehilculeService {

    @Autowired
    VehiculeRepository vehiculeRepository;

    @Autowired
    VehilculeMapper vehilculeMapper;

    @Autowired
    private LivraisonRepository livraisonRepository;

    public VehiculeDTO save(Vehicule vehicule){
        Vehicule v = vehiculeRepository.save(vehicule);
        return vehilculeMapper.toDTO(v);
    }

    public void delete(long id){
        vehiculeRepository.deleteById(id);
    }

    public VehiculeDTO update(long id, VehiculeDTO vehicule){
        Vehicule v = vehiculeRepository.findById(id).orElse(null);

        v.setMatricule(vehicule.getMatricule());
        v.setCapacite(vehicule.getCapacite());
        v.setStatus(vehicule.getStatus());
        v.setType(vehicule.getType());

        Vehicule update = vehiculeRepository.save(v);

        return vehilculeMapper.toDTO(update);
    }

    public List<VehiculeDTO> findByStatut(String statut) {
        return vehilculeMapper.todtolist(vehiculeRepository.findByStatus(statut)) ;
    }
    public List<VehiculeDTO> findByCapaciteGreaterThan(int capacite){
        return vehilculeMapper.todtolist(vehiculeRepository.findByCapaciteGreaterThan(capacite));

    }

    public List<VehiculeDTO> getAllvicule(){
        List<VehiculeDTO>  allVeculte = vehilculeMapper.todtolist(vehiculeRepository.findAll());
        allVeculte.forEach(v->{
            long total = livraisonRepository.countAllByVehicule(v.getId());
            v.setTotalcount(total);
        });

        return allVeculte;
    }
}
