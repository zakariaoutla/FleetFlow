package com.example.FleetFlow.repository;


import com.example.FleetFlow.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
