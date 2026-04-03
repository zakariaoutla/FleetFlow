package com.example.FleetFlow.repository;

import com.example.FleetFlow.Models.Vehicule;
import com.example.FleetFlow.dto.VehiculeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    List<Vehicule> findByStatus(String status);

    List<Vehicule> findByCapaciteGreaterThan(int capacite);
}
