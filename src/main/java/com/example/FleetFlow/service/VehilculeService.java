package com.example.FleetFlow.service;


import com.example.FleetFlow.Models.Vehicule;
import com.example.FleetFlow.dto.VehiculeDTO;
import com.example.FleetFlow.mapper.VehilculeMapper;
import com.example.FleetFlow.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehilculeService {

    @Autowired
    VehiculeRepository vehiculeRepository;

    @Autowired
    VehilculeMapper vehilculeMapper;

    public VehiculeDTO save(Vehicule vehicule){
        Vehicule v = vehiculeRepository.save(vehicule);
        return vehilculeMapper.toDTO(v);
    }

    public void delete(long id){
        vehiculeRepository.deleteById(id);
    }

    public List<VehiculeDTO> getAllVehicule(){
        List<VehiculeDTO> vehicules = vehiculeRepository.findAll().stream().map(vehilculeMapper::toDTO).toList();
        return vehicules;
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

    public List<VehiculeDTO> findByStatut(String status){
        return vehiculeRepository.findByStatut(status);
    }

    public List<VehiculeDTO> findByCapaciteGreaterThan(int capacite){
        return vehiculeRepository.findByCapaciteGreaterThan(capacite);
    }
}
