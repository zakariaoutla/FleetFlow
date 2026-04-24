package com.example.FleetFlow.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "client")
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String email;
    private String telephone;
    private String ville;
    protected String prenom;

  //comnter
    public Client(String nom, String email, String ville, String telephone) {
        this.nom = nom;
        this.email = email;
        this.ville = ville;
        this.telephone = telephone;
    }
}
