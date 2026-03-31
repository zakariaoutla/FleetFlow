package com.example.FleetFlow.mapper;

import com.example.FleetFlow.dto.VehiculeDTO;
import com.example.FleetFlow.Models.Vehicule;
import org.springframework.web.bind.annotation.Mapping;

@Mapping()
public interface VehilculeMapper {

    VehiculeDTO toDTO(Vehicule vehicule);

}
