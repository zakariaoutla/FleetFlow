package com.example.FleetFlow.repository;

import com.example.FleetFlow.Models.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChauffeurRepository extends JpaRepository<Chauffeur , Long> {
    List<Chauffeur> findChauffeurByDisponibleTrue();
}
