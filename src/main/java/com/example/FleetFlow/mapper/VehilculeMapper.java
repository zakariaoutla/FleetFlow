package com.example.FleetFlow.mapper;

import com.example.FleetFlow.dto.VehiculeDTO;
import com.example.FleetFlow.Models.Vehicule;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehilculeMapper {

    VehiculeDTO toDTO(Vehicule vehicule);

    List<VehiculeDTO> todtolist(List<Vehicule> vehicules);

}
