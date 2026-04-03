package com.example.FleetFlow.mapper;

import com.example.FleetFlow.Models.Livraison;
import com.example.FleetFlow.dto.LivraisonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LivraisonMapper {

    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "chauffeur.id", target = "chauffeurId")
    @Mapping(source = "vehicule.id", target = "vehiculeId")
    LivraisonDTO toDto(Livraison livraison);

    @Mapping(source = "clientId", target = "client.id")
    @Mapping(source = "chauffeurId", target = "chauffeur.id")
    @Mapping(source = "vehiculeId", target = "vehicule.id")
    Livraison toEntity(LivraisonDTO livraisonDTO);
}
