package com.example.FleetFlow.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ClientDTO {

    @NotBlank(message = "Name is required")
    private String nom;
    @Email
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank
    @Size(min = 10, max = 10, message = "Phone must be 10 digits")
    private String telephone;
    @NotBlank
    private String ville;
}
