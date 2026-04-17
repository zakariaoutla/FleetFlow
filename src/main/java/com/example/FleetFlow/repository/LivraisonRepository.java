package com.example.FleetFlow.repository;

import com.example.FleetFlow.Models.Livraison;
import com.example.FleetFlow.enums.StatutLivraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface LivraisonRepository extends JpaRepository<Livraison , Long> {
    List<Livraison> findByStatut(StatutLivraison statut);
    List<Livraison> findByClientId(Long clientId);

    @Query("SELECT l FROM Livraison l WHERE l.dateLivraison BETWEEN :startDate AND :endDate")
    List<Livraison> findLivraisonsBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("SELECT l FROM Livraison l WHERE l.adresseDestination LIKE %:ville%")
    List<Livraison> findByVilleDestination(@Param("ville") String ville);

    @Query(value = "SELECT count(*) FROM livraison l WHERE l.vehicule_id = :id", nativeQuery = true)
    long countAllByVehicule(long id);
}
