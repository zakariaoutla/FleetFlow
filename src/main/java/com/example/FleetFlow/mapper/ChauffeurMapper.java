package com.example.FleetFlow.mapper;
import com.example.FleetFlow.Models.Chauffeur;
import com.example.FleetFlow.dto.ChauffeurDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChauffeurMapper {
    ChauffeurDTO toDto(Chauffeur chauffeur);
    Chauffeur toEntity(ChauffeurDTO chauffeurDTO);
}