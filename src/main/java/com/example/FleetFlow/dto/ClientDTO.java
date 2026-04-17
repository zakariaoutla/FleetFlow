package com.example.FleetFlow.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
public class ClientDTO {


    private long id;
    @NotBlank(message = "Name is required")
    private String nom;
    @Email
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "telephone is required")
    private String telephone;
    @NotBlank(message = "ville is required")
    private String ville;
    private String prenom;

    public ClientDTO(String nom, String email, String ville, String telephone) {
        this.nom = nom;
        this.email = email;
        this.ville = ville;
        this.telephone = telephone;
    }
}
