package com.example.FleetFlow.repository;

import com.example.FleetFlow.Models.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}
